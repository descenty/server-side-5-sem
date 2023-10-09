package com.mirea.practice6.infrastructure.schema.out;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(UUID id, String title, String description, BigDecimal price, Integer stockQuantity) {
}
