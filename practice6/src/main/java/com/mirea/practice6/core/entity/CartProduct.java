package com.mirea.practice6.core.entity;

import java.util.UUID;

public class CartProduct extends Entity<UUID> {
    protected UUID cartId;
    protected UUID productId;
    protected Byte quantity = 1;

    public CartProduct() {
    }

    public CartProduct(UUID cartId, UUID productId, Byte quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public UUID getCartId() {
        return cartId;
    }
}
