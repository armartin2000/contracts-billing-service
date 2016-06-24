package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@ApiModel(value = "ServiceOrder", parent = Contract.class)
public class ServiceOrder extends Contract {


    @OneToMany(cascade = CascadeType.ALL)
    @ApiModelProperty
    private List<ServiceItem> serviceItems;

    @Transient
    @ApiModelProperty
    private List<ServiceItem> recurringItems;

    @Transient
    @ApiModelProperty
    private List<ServiceItem> nonRecurringItems;

    protected List<ServiceItem> getServiceItems() {
        return serviceItems;
    }

    protected void setServiceItems(List<ServiceItem> serviceItems) {
        this.serviceItems = serviceItems;
        setRecurringItems(serviceItems.stream()
                .filter(ServiceItem::isRecurring)
                .collect(Collectors.toList()));
        setNonRecurringItems(serviceItems.stream()
                .filter(ServiceItem::isNonRecurring)
                .collect(Collectors.toList()));
    }

    public List<ServiceItem> getRecurringItems() {
        if (recurringItems == null) {
            setRecurringItems(serviceItems.stream()
                    .filter(ServiceItem::isRecurring)
                    .collect(Collectors.toList()));
        }
        return recurringItems;
    }

    public void setRecurringItems(List<ServiceItem> recurringItems) {
        this.recurringItems = recurringItems;
    }

    public List<ServiceItem> getNonRecurringItems() {
        if (nonRecurringItems == null) {
            setNonRecurringItems(serviceItems.stream()
                    .filter(ServiceItem::isNonRecurring)
                    .collect(Collectors.toList()));
        }
        return nonRecurringItems;
    }

    public void setNonRecurringItems(List<ServiceItem> nonRecurringItems) {
        this.nonRecurringItems = nonRecurringItems;
    }


}
