package com.mirea.practice6.core.schema.in;

import java.util.UUID;

public record CartProductCreateDTO(UUID productId, Byte quantity) {
}
