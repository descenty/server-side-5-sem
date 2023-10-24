package com.mirea.practice6.core.schema.in;

import jakarta.validation.constraints.NotNull;

public record CartProductChangeDTO(@NotNull Byte quantity) {
}