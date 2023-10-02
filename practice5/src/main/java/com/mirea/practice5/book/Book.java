package com.mirea.practice5.book;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Book(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id,
        String title,
        String author,
        String type,
        Integer price,
        Integer sellerId) {
}