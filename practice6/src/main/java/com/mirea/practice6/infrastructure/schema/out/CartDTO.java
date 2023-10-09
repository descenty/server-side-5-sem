package com.mirea.practice6.infrastructure.schema.out;

import java.util.List;
import java.util.UUID;

import com.mirea.practice6.core.entity.CartProduct;

public record CartDTO(UUID id, UUID userId, List<CartProduct> products) {
}
