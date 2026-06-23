package com.NewCycle.cashtrash.model;

import com.NewCycle.cashtrash.model.enums.TipoUser;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    private Boolean active = true;
    @Enumerated(EnumType.STRING)
    private TipoUser type;
    private OffsetDateTime dateNasc;
    private String cfp;

    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    public User() {
    }

    public User(String name, String email, String password, TipoUser type,
                OffsetDateTime dateNasc, String cfp) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.dateNasc = dateNasc;
        this.cfp = cfp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public TipoUser getType() {
        return type;
    }

    public void setType(TipoUser type) {
        this.type = type;
    }

    public OffsetDateTime getDateNasc() {
        return dateNasc;
    }

    public void setDateNasc(OffsetDateTime dateNasc) {
        this.dateNasc = dateNasc;
    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist(){
        createdAt = OffsetDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = OffsetDateTime.now();
    }
}
