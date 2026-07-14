package com.NewCycle.cashtrash.dtos.request;

import com.NewCycle.cashtrash.model.enums.TipoUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class RequestPostUser {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoUser type;
    @NotNull
    private String cfp;

    public RequestPostUser(String name, String email, String password,
                           TipoUser type, String cfp) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.cfp = cfp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUser getType() {
        return type;
    }

    public void setType(TipoUser type) {
        this.type = type;
    }


    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }
}
