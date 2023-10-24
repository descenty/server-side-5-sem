package com.mirea.practice6.core.schema.out;

import java.util.List;
import java.util.UUID;

public record CartDTO(UUID userId, List<CartProductDTO> products) {
}
