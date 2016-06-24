package com.gci.service.contract.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum TermTypeEnum {

    MONTH("month"),

    YEAR("year"),

    DAY("day");

    private final String value;

    TermTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TermTypeEnum fromValue(String v) {
        for (TermTypeEnum c : TermTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
