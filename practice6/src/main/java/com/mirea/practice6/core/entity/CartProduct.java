package com.mirea.practice6.core.entity;

import java.util.UUID;

public class CartProduct extends Entity<UUID> {
    protected UUID cartId;
    protected Byte quantity;
}
