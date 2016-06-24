package com.gci.service.contract.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ApiModel(subTypes = {LineItemContract.class, ServiceAgreement.class, ServiceOrder.class})
@JsonSubTypes({
        @JsonSubTypes.Type(value = LineItemContract.class),
        @JsonSubTypes.Type(value = ServiceAgreement.class),
        @JsonSubTypes.Type(value = ServiceOrder.class)
})
public abstract class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @NotNull
    @ManyToOne
    @ApiModelProperty
    private ContractParentAccount contractParentAccount; //relate contract(s)

    @NotNull
    @ApiModelProperty
    private String contractNumber;

    @NotNull
    @ManyToOne
    @ApiModelProperty
    private User user; //contract owner

    @OneToMany(cascade = CascadeType.ALL)
    @ApiModelProperty
    private Set<Invoice> invoices = new HashSet<>();

    @NotNull
    @ApiModelProperty
    private Date effectiveDate;
    @NotNull
    @ApiModelProperty
    private Date terminationDate;
    @ApiModelProperty
    private Integer term;
    @ApiModelProperty
    private TermTypeEnum termType;
    @ApiModelProperty
    private String termlimit;
    @ApiModelProperty
    private Double sumTotalServicesRate;
    @ApiModelProperty
    private BillingCycleEnum recurringBillingCycle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContractParentAccount getContractParentAccount() {
        return contractParentAccount;
    }

    public void setContractParentAccount(ContractParentAccount contractParentAccount) {
        this.contractParentAccount = contractParentAccount;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public TermTypeEnum getTermType() {
        return termType;
    }

    public void setTermType(TermTypeEnum termType) {
        this.termType = termType;
    }

    public String getTermlimit() {
        return termlimit;
    }

    public void setTermlimit(String termlimit) {
        this.termlimit = termlimit;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public BillingCycleEnum getRecurringBillingCycle() {
        return recurringBillingCycle;
    }

    public void setRecurringBillingCycle(BillingCycleEnum recurringBillingCycle) {
        this.recurringBillingCycle = recurringBillingCycle;
    }

    public Double getSumTotalServicesRate() {
        return sumTotalServicesRate;
    }

    public void setSumTotalServicesRate(Double sumTotalServicesRate) {
        this.sumTotalServicesRate = sumTotalServicesRate;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
