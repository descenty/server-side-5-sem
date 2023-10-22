package com.mirea.practice6.core.entity;

import java.util.UUID;

public class OrderProduct extends Entity<UUID> {
    protected UUID orderId;
    protected UUID productId;
    protected Byte quantity;

    public UUID getProductId() {
        return productId;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public OrderProduct(UUID orderId, UUID productId, Byte quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
