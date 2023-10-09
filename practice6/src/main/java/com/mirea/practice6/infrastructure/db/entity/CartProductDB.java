package com.mirea.practice6.infrastructure.db.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.entity.CartProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartProductDB extends CartProduct {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    @JsonInclude
    private Cart cart;

    @Column(name = "cart_id", nullable = true)
    @JsonIgnore
    private UUID cartId;
}
