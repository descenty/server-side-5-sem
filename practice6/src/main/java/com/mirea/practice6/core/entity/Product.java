package com.mirea.practice6.core.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    protected UUID id;
    protected String title;
    protected String description;
    protected BigDecimal price;
    protected Integer stockQuantity;
}
