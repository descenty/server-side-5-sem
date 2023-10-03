package com.mirea.practice5.client.schema;

import jakarta.validation.constraints.NotEmpty;

public record ClientCreate(
        @NotEmpty String name,
        @NotEmpty String email,
        @NotEmpty String login,
        @NotEmpty String password) {
}