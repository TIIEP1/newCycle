package com.NewCycle.cashtrash.model;

import com.NewCycle.cashtrash.model.enums.TypeTrash;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "trashes")
public class Trash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeTrash type;

    @ManyToOne
    @JoinColumn(name = "trashcan_id")
    private Trashcan   trashcan;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal weight;
    private OffsetDateTime discardDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeTrash getType() {
        return type;
    }

    public void setType(TypeTrash type) {
        this.type = type;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public OffsetDateTime getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(OffsetDateTime discardDate) {
        this.discardDate = discardDate;
    }
}
