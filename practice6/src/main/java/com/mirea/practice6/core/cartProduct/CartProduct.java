package com.mirea.practice6.core.cartProduct;

import java.util.UUID;

public record CartProduct(
        UUID id,
        UUID cartId,
        Byte quantity) {
}
