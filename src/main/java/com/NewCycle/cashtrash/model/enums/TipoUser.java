package com.NewCycle.cashtrash.model.enums;

public enum TipoUser {

    CUSTOMER("Cliente"),
    EMPLOYEE("Funcionario");

    private final String description;

    TipoUser(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
