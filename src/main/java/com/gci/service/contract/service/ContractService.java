package com.gci.service.contract.service;

import com.gci.service.contract.model.Contract;
import com.gci.service.contract.model.ContractBillingSummary;
import com.gci.service.contract.model.LineItemContract;
import com.gci.service.contract.model.RateTypeEnum;
import com.gci.service.contract.model.ServiceAgreement;
import com.gci.service.contract.model.ServiceOrder;
import com.gci.service.contract.model.User;
import com.gci.service.contract.repository.LineItemContractRepository;
import com.gci.service.contract.repository.ServiceAgreementRepository;
import com.gci.service.contract.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Service
public class ContractService {

    @Autowired
    UserService userService;

    private LineItemContractRepository lineItemContractRepository;
    private ServiceAgreementRepository serviceAgreementRepository;
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    public ContractService (
            LineItemContractRepository lineItemContractRepository,
            ServiceAgreementRepository serviceAgreementRepository,
            ServiceOrderRepository serviceOrderRepository) {
       this.lineItemContractRepository = lineItemContractRepository;
        this.serviceAgreementRepository = serviceAgreementRepository;
        this.serviceOrderRepository = serviceOrderRepository;
    }

    public List<LineItemContract> getLineItemContractsByOwner(String ownerId) {
        return  lineItemContractRepository.findByUserId(Long.valueOf(ownerId));
    }

    public LineItemContract createLineItemContract(LineItemContract contract) {
        return lineItemContractRepository.save(contract);
    }

    public List<ServiceAgreement> getServiceAgreementByOwner(String ownerId) {
        return  serviceAgreementRepository.findByUserId(Long.valueOf(ownerId));
    }

    public ServiceAgreement createServiceAgreement(ServiceAgreement contract) {
        return serviceAgreementRepository.save(contract);
    }

    public List<ServiceOrder> getServiceOrderByOwner(String ownerId) {
        return  serviceOrderRepository.findByUserId(Long.valueOf(ownerId));
    }

    public ServiceOrder createServiceOrder(ServiceOrder contract) {
        return serviceOrderRepository.save(contract);
    }

    public List<Contract> getContractsByOwner(String ownerId) {
        List<ServiceOrder> serviceOrders = getServiceOrderByOwner(ownerId);
        List<ServiceAgreement> serviceAgreements = getServiceAgreementByOwner(ownerId);
        List<LineItemContract> lineItemContracts = getLineItemContractsByOwner(ownerId);

        Stream<Contract> contracts = Stream.concat(serviceOrders.stream(),
                Stream.concat(serviceAgreements.stream(), lineItemContracts.stream()));

        return contracts.collect(Collectors.toList());

    }

    public ContractBillingSummary getContractsBilingSummaryByOwner(String ownerId) {

        ContractBillingSummary billingSummary = new ContractBillingSummary();



        List<ServiceOrder> serviceOrders = getServiceOrderByOwner(ownerId);
        List<ServiceAgreement> serviceAgreements = getServiceAgreementByOwner(ownerId);
        List<LineItemContract> lineItemContracts = getLineItemContractsByOwner(ownerId);

        Stream<Contract> contractStream = Stream.concat(serviceOrders.stream(),
                Stream.concat(serviceAgreements.stream(), lineItemContracts.stream()));
        Set<Contract> contracts = contractStream.collect(Collectors.toSet());

        //Populate Summary Bean
        // gci sales contact
        billingSummary.setGciSalesContact(getOwnerNameByOwnerId(ownerId));
        //all contracts
        billingSummary.setContracts(contracts);

        // rate type (i.e. monthly, yearly..)
        if(serviceAgreements.size() > 1)
            billingSummary.setRateType(getContractAgreementRateType(serviceAgreements.get(0)));
        //all contracts rate (monthly) total
        billingSummary.setSumTotalContractRate(calculateSumTotalContractRate(contracts));
        // number of contracts
        billingSummary.setSumContracts(contracts.size());
        //TODO: calculate number of sites : sumServiceSites
        //TODO: calculate number of sites : sumInvoicesPastDue
        //TODO: calculate number of sites : sumContractsExpiring

        return billingSummary;

    }

    private String getOwnerNameByOwnerId(String ownerId) {
        User user = userService.getUserById(ownerId);
        return (user != null) ? user.getFullName() : "";
    }

    private Double calculateSumTotalContractRate(Set<Contract> contracts) {
        return contracts.stream().map(Contract::getSumTotalServicesRate).flatMapToDouble(n-> DoubleStream.of(n)).sum();
    }

    private RateTypeEnum getContractAgreementRateType(ServiceAgreement serviceAgreement) {
        return serviceAgreement.getBillingRateType();
    }

}
