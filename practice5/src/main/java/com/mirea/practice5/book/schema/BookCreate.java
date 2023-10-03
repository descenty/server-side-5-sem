package com.mirea.practice5.book.schema;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record BookCreate(
        @NotEmpty String title,
        @NotEmpty String author,
        @Positive Double price,
        @Positive Integer sellerId) {
}