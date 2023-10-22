package com.mirea.practice6.infrastructure.db.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mirea.practice6.core.entity.OrderProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_product")
public class OrderProductDB extends OrderProduct {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonInclude
    private OrderDB order;

    @Column(name = "order_id", nullable = true)
    @JsonIgnore
    private UUID orderId;

    public OrderProductDB(UUID orderId, UUID productId, Byte quantity) {
        super(orderId, productId, quantity);
    }
}
