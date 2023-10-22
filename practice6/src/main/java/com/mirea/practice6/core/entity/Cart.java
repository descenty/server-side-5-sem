package com.mirea.practice6.core.entity;

import java.util.List;
import java.util.UUID;

public class Cart extends Entity<UUID> {
    protected UUID userId;
    protected List<CartProduct> products;
}
