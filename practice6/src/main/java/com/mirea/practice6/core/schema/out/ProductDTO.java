package com.mirea.practice6.core.schema.out;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, BigDecimal price, Integer stockQuantity) {
}
