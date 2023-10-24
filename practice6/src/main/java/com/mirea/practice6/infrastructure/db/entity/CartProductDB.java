package com.mirea.practice6.infrastructure.db.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.mirea.practice6.core.entity.CartProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_product")
@Getter
@Setter
public class CartProductDB extends CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    @JsonIgnore
    private CartDB cart;

    @Column(name = "cart_id", nullable = false)
    @JsonIgnore
    private UUID cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonIncludeProperties({ "id", "name", "description", "price", "stockQuantity" })
    private ProductDB product;

    @Column(name = "product_id", nullable = false)
    @JsonIgnore
    private UUID productId;

    @Column(nullable = false)
    private Byte quantity;
}
