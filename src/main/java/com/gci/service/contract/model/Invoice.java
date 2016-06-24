package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@ApiModel
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @ApiModelProperty
    private String invoiceNumber;

    @NotNull
    @ManyToOne
    @ApiModelProperty
    private ContractParentAccount contractParentAccount; //relate contract(s)

    @NotNull
    @ManyToOne
    @ApiModelProperty
    private Contract contract;

    @ApiModelProperty
    private StatusEnum status;

    @NotNull
    @ApiModelProperty
    private Date dueDate;

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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
