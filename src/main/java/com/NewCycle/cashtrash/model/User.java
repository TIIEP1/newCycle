package com.NewCycle.cashtrash.model;

import com.NewCycle.cashtrash.model.enums.TipoUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

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
    private String cfp;
    @OneToOne(mappedBy = "user", cascade =CascadeType.ALL)
    private Wallet wallet;

    private Double totalColetado;

    private Integer descartes;


    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    public User() {
    }

    public User(String name, String email, String password, TipoUser type,
                 String cfp) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.cfp = cfp;
        this.totalColetado = 0.0;
        this.descartes = 0;
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

    public Double getTotalColetado() {
        return totalColetado;
    }

    public void setTotalColetado(Double totalColetado) {
        this.totalColetado = totalColetado;
    }

    public Integer getDescartes() {
        return descartes;
    }

    public void setDescartes(Integer descartes) {
        this.descartes = descartes;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
