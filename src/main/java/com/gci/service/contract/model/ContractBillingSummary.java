package com.gci.service.contract.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

@ApiModel
public class ContractBillingSummary {

    @ApiModelProperty
    private Double sumTotalContractRate;
    @ApiModelProperty
    private RateTypeEnum rateType;
    @ApiModelProperty
    private String gciSalesContact;
    @ApiModelProperty
    private Integer sumServiceSites;
    @ApiModelProperty
    private Integer sumContracts;
    @ApiModelProperty
    private Integer sumInvoicesPastDue;
    @ApiModelProperty
    private Integer sumContractsExpiring;

    @ApiModelProperty
    private Set<Contract> contracts;

    public Double getSumTotalContractRate() {
        return sumTotalContractRate;
    }

    public void setSumTotalContractRate(Double sumTotalContractRate) {
        this.sumTotalContractRate = sumTotalContractRate;
    }

    public RateTypeEnum getRateType() {
        return rateType;
    }

    public void setRateType(RateTypeEnum rateType) {
        this.rateType = rateType;
    }

    public String getGciSalesContact() {
        return gciSalesContact;
    }

    public void setGciSalesContact(String gciSalesContact) {
        this.gciSalesContact = gciSalesContact;
    }

    public Integer getSumServiceSites() {
        return sumServiceSites;
    }

    public void setSumServiceSites(Integer sumServiceSites) {
        this.sumServiceSites = sumServiceSites;
    }

    public Integer getSumContracts() {
        return sumContracts;
    }

    public void setSumContracts(Integer sumContracts) {
        this.sumContracts = sumContracts;
    }

    public Integer getSumInvoicesPastDue() {
        return sumInvoicesPastDue;
    }

    public void setSumInvoicesPastDue(Integer sumInvoicesPastDue) {
        this.sumInvoicesPastDue = sumInvoicesPastDue;
    }

    public Integer getSumContractsExpiring() {
        return sumContractsExpiring;
    }

    public void setSumContractsExpiring(Integer sumContractsExpiring) {
        this.sumContractsExpiring = sumContractsExpiring;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
