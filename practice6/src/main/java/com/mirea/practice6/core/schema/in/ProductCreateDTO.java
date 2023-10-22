package com.mirea.practice6.core.schema.in;

import java.math.BigDecimal;

public record ProductCreateDTO(String title, String description, BigDecimal price, Integer stockQuantity) {
}