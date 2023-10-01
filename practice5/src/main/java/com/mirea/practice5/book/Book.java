package com.mirea.practice5.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Book(
        @Id Long id,
        String title,
        String author,
        String type,
        Integer price,
        Integer sellerId) {
}