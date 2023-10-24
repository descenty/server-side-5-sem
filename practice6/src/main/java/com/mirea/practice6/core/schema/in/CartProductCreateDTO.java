package com.mirea.practice6.core.schema.in;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record CartProductCreateDTO(@NotNull UUID cartId, @NotNull UUID productId, Byte quantity) {
    public CartProductCreateDTO {
        if (quantity == null) {
            quantity = 1;
        }
    }
}
