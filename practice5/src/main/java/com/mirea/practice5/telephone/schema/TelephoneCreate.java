package com.mirea.practice5.telephone.schema;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record TelephoneCreate(
        @NotEmpty String title,
        @Positive Double price,
        @Positive Integer batteryCapacity,
        @NotEmpty String manufacturer,
        @Positive Integer sellerId) {
}