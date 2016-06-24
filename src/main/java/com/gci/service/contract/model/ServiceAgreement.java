package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

@Entity
@ApiModel(value = "ServiceAgreement", parent = Contract.class)
public class ServiceAgreement extends Contract {

    @ApiModelProperty
    private String projectSummary;
    @ApiModelProperty
    private String sowDescription;
    @ApiModelProperty
    private RateTypeEnum billingRateType;

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    public String getSowDescription() {
        return sowDescription;
    }

    public void setSowDescription(String sowDescription) {
        this.sowDescription = sowDescription;
    }

    public RateTypeEnum getBillingRateType() {
        return billingRateType;
    }

    public void setBillingRateType(RateTypeEnum billingRateType) {
        this.billingRateType = billingRateType;
    }
}
