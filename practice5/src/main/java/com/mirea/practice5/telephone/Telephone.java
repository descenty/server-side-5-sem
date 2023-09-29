package com.mirea.practice5.telephone;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Telephone {
    @Id
    private Long id;
    private String title;
    private String type;
    private Integer price;
    private Integer batteryCapacity;
    private String manufacturer;
    private Integer sellerId;
}