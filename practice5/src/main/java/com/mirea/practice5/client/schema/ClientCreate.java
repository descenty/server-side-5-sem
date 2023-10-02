package com.mirea.practice5.client.schema;

public record ClientCreate(
        String name,
        String email,
        String login,
        String password) {
}