package com.mirea.practice5.washingMachine;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record WashingMachine(
        @Id Long id,
        String title,
        String type,
        Integer price,
        Integer tankVolume,
        String manufacturer,
        Integer sellerId) {
}