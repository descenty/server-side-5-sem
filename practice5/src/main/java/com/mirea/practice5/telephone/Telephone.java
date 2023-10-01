package com.mirea.practice5.telephone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Telephone(
        @Id Long id,
        String title,
        String type,
        Integer price,
        Integer batteryCapacity,
        String manufacturer,
        Integer sellerId) {
}