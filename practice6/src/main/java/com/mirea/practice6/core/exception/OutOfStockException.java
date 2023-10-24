package com.mirea.practice6.core.exception;

import java.util.List;
import java.util.stream.Collectors;

import com.mirea.practice6.core.entity.Product;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(Product product) {
        super(String.format("%s: максимум %s шт.", product.getName(),
                product.getStockQuantity()));
    }

    public OutOfStockException(List<Product> products) {
        super("Нет на складе: "
                + products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}