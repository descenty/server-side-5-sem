package com.mirea.practice6.core.schema.in;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record CartCreateDTO(@NotNull UUID userId) {
}
