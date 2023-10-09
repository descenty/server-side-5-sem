package com.mirea.practice6.core.entity;

import java.util.List;
import java.util.UUID;

public class Cart {
    protected UUID id;
    protected UUID userId;
    protected List<CartProduct> products;
}
