package com.mirea.practice6.core.schema.in;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductCreateDTO(@NotNull String name, @NotNull String description, @Min(1) BigDecimal price,
        @Min(1) Integer stockQuantity) {
}