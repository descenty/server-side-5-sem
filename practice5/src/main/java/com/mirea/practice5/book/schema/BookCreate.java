package com.mirea.practice5.book.schema;

public record BookCreate(
        String title,
        String author,
        String type,
        Integer price,
        Integer sellerId) {
}