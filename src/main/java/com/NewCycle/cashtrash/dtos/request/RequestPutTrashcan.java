package com.NewCycle.cashtrash.dtos.request;

import java.math.BigDecimal;
import java.util.Optional;

public class RequestPutTrashcan {

    private String name;
    private Boolean fully;
    private BigDecimal capacidade;
    private Boolean active;

    public RequestPutTrashcan() {
    }

    public RequestPutTrashcan(String name, Boolean fully, String capacidade, Boolean active) {
        this.name = name;
        this.fully = fully;
        this.capacidade = new BigDecimal(capacidade);
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFully() {
        return fully;
    }

    public void setFully(Boolean fully) {
        this.fully = fully;
    }

    public BigDecimal getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(BigDecimal capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
