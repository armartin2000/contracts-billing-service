package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@ApiModel(value = "LineItemContract", parent = Contract.class)
public class LineItemContract extends Contract {

    @OneToMany(cascade = CascadeType.ALL)
    @ApiModelProperty
    private Set<ServiceItem> serviceItems = new HashSet<>();

    public Set<ServiceItem> getServiceItems() {
        return serviceItems;
    }

    public void setServiceItems(Set<ServiceItem> serviceItems) {
        this.serviceItems = serviceItems;
    }

}
