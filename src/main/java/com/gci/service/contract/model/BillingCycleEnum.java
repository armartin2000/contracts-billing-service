package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum  BillingCycleEnum {

    MONTHLY("monthly"),

    YEARLY("yearly"),

    ONETIME(" ");

    private final String value;

    BillingCycleEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BillingCycleEnum fromValue(String v) {
        for (BillingCycleEnum c : BillingCycleEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
