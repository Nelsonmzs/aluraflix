package com.nelson.aluraflix.Enum;

public enum CategoryEnum {

    FREE(1);

    private final int value;

    CategoryEnum(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
