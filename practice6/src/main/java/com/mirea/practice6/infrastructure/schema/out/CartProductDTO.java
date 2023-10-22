package com.mirea.practice6.infrastructure.schema.out;

import java.util.UUID;

public record CartProductDTO(UUID cartId, UUID productId, Byte quantity) {
}