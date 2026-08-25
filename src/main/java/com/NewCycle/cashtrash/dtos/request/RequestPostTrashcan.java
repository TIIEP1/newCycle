package com.NewCycle.cashtrash.dtos.request;

import com.NewCycle.cashtrash.model.Address;
import com.NewCycle.cashtrash.model.Trashcan;

import java.math.BigDecimal;

public record RequestPostTrashcan(String name, String fully, String capacidade, Address address) {

    public Trashcan toTrashcan()
    {
        return new Trashcan(this.name, Boolean.parseBoolean(fully),new BigDecimal(capacidade), address);

    }
}
