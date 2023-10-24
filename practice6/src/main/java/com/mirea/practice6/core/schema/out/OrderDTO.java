package com.mirea.practice6.core.schema.out;

import java.util.List;
import java.util.UUID;

public record OrderDTO (UUID userId, List<OrderProductDTO> products) {
}
