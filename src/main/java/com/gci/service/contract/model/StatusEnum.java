package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum StatusEnum {

    PAST_DUE("past due"),

    EXPIRING("expiring");

    private final String value;

    StatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusEnum fromValue(String v) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
