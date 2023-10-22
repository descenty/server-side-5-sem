package com.mirea.practice6.core.exception;

import java.util.List;
import java.util.stream.Collectors;

import com.mirea.practice6.core.entity.Product;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(Product product) {
        super("Out of stock: " + product.getName());
    }

    public OutOfStockException(List<Product> products) {
        super("Out of stock: " + products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}