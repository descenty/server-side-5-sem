package com.mirea.practice6.infrastructure.db.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mirea.practice6.core.entity.Cart;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class CartDB extends Cart<CartProductDB> {
    @Id
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonInclude
    private List<CartProductDB> products;

    public CartDB() {
    }

    public CartDB(UUID userId) {
        super(userId);
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<CartProductDB> getProducts() {
        return products;
    }

    public void setProducts(List<CartProductDB> products) {
        this.products = products;
    }
}
