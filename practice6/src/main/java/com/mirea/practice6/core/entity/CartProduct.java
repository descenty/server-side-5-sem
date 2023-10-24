package com.mirea.practice6.core.entity;

import java.util.UUID;

public class CartProduct extends Entity<UUID> {
    protected UUID cartId;
    protected UUID productId;
    protected Byte quantity;

    public UUID getProductId() {
        return productId;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public CartProduct() {
    }

    public UUID getId() {
        return cartId;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public CartProduct(UUID cartId, UUID productId, Byte quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
