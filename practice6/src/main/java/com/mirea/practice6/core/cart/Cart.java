package com.mirea.practice6.core.cart;

import java.math.BigDecimal;
import java.util.List;

import com.mirea.practice6.core.cartProduct.CartProduct;

public record Cart() {
    private final List<CartProduct> products;
    private final BigDecimal total;
    private final BigDecimal discount;
    private final BigDecimal totalWithDiscount;
}
