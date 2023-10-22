package com.mirea.practice6.infrastructure.schema.in;

import java.util.UUID;

public record CartProductCreateDTO(UUID cartId, UUID productId, Byte quantity) {
}
