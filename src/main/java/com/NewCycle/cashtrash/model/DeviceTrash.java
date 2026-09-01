package com.NewCycle.cashtrash.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "device_trash")
public class DeviceTrash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid = UUID.randomUUID();
    private Boolean connected = false;
    private OffsetDateTime lastSeen;
    @OneToOne(mappedBy = "deviceTrash")
    private Trashcan trashcan;

    public DeviceTrash() {
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Boolean getConnected() {
        return connected;
    }

    public OffsetDateTime getLastSeen() {
        return lastSeen;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public void setLastSeen(OffsetDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Trashcan getTrashcan() {
        return trashcan;
    }

    public void setTrashcan(Trashcan trashcan) {
        this.trashcan = trashcan;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
