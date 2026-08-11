package com.NewCycle.cashtrash.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="trashcans")
public class Trashcan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean fully;
    private BigDecimal capacidade;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @OneToMany(mappedBy = "trashcan")
    private List<Trash> trashes = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    public Trashcan() {
    }

    public Trashcan(Long id, Boolean fully, BigDecimal capacidade,
                    Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.fully = fully;
        this.capacidade = capacidade;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Trash> getTrashes() {
        return trashes;
    }

    public void setTrashes(List<Trash> trashes) {
        this.trashes = trashes;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
