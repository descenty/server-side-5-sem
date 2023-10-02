package com.mirea.practice5.telephone.schema;

public record TelephoneCreate(
        String title,
        String type,
        Integer price,
        Integer batteryCapacity,
        String manufacturer,
        Integer sellerId) {
}