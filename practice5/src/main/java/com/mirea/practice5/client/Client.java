package com.mirea.practice5.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Client(
        @Id Long id,
        String name,
        String email,
        String login,
        String password) {
}