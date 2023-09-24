package com.guilherme.crudspring.enums;

public enum Status {
    ACTIVE("ATIVO"),
    INACTIVE("INATIVO");

    private String value;

    private Status(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
