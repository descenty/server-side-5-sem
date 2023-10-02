package com.mirea.practice5.washingMachine.schema;

public record WashingMachineCreate(
        String title,
        String type,
        Integer price,
        Integer tankVolume,
        String manufacturer,
        Integer sellerId) {
}