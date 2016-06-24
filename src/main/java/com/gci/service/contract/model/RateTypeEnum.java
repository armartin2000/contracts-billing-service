package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum RateTypeEnum {

    RECURRING("recurring"),

    NONRECURRING("non-recurring"),

    HOURLY("hourly");

    private final String value;

    RateTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RateTypeEnum fromValue(String v) {
        for (RateTypeEnum c : RateTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
