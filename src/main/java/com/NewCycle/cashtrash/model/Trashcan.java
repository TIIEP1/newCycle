package com.NewCycle.cashtrash.model;

import com.NewCycle.cashtrash.dtos.request.RequestPostTrashcan;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="trashcans")
public class Trashcan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "device_trash_id")
    private DeviceTrash deviceTrash = new DeviceTrash();
    private String name;
    private Boolean fully;
    private BigDecimal capacidade;
    private Boolean active = true;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @OneToMany(mappedBy = "trashcan")
    private List<Trash> trashes = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    public Trashcan() {
    }

    public Trashcan(String name ,Boolean fully, BigDecimal capacidade, Address address) {
        this.fully = fully;
        this.capacidade = capacidade;
        this.address = address;
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

    public DeviceTrash getDeviceTrash() {
        return deviceTrash;
    }

    public void setDeviceTrash(DeviceTrash deviceTrash) {
        this.deviceTrash = deviceTrash;
    }
}
