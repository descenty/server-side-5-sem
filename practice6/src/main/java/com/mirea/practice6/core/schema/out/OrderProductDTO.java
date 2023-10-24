package com.mirea.practice6.core.schema.out;

import java.util.UUID;

public record OrderProductDTO(UUID orderId, UUID productId, Byte quantity) {
}
