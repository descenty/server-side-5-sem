package com.mirea.practice6.core.schema.out;

import java.util.UUID;

public record CartProductDTO(UUID cartId, UUID productId, Byte quantity) {
}