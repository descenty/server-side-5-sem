package com.mirea.practice6.core.entity;

import java.util.List;
import java.util.UUID;

public class Cart<CP extends CartProduct> extends Entity<UUID> {
    protected UUID userId;
    protected List<CP> products;

    public Cart() {
    }

    public Cart(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<CP> getProducts() {
        return products;
    }
}
