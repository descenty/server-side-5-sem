package com.mirea.practice5.washingMachine.schema;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record WashingMachineCreate(
        @NotEmpty String title,
        @Positive Double price,
        @Positive Integer tankVolume,
        @NotEmpty String manufacturer,
        @Positive Integer sellerId) {
}