package com.gci.service.contract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@ApiModel
public class ServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    protected Long id;
    @NotNull
    @ApiModelProperty
    private Double rate;
    @NotNull
    @ApiModelProperty
    private RateTypeEnum rateType;
    @NotNull
    @ApiModelProperty
    private BillingCycleEnum billingCycleEnum;

    @ManyToOne
    @ApiModelProperty
    private Site site;

    @ApiModelProperty
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public RateTypeEnum getRateType() {
        return rateType;
    }

    public void setRateType(RateTypeEnum rateType) {
        this.rateType = rateType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public boolean isRecurring() {
        return this.rateType.equals(RateTypeEnum.RECURRING);
    }
    @JsonIgnore
    public boolean isNonRecurring() {
        return this.rateType.equals(RateTypeEnum.NONRECURRING);
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public BillingCycleEnum getBillingCycleEnum() {
        return billingCycleEnum;
    }

    public void setBillingCycleEnum(BillingCycleEnum billingCycleEnum) {
        this.billingCycleEnum = billingCycleEnum;
    }
}
