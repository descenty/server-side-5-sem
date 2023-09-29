package com.mirea.practice5.washingMachine;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WashingMachine {
    @Id
    private Long id;
    private String title;
    private String type;
    private Integer price;
    private Integer tankVolume;
    private String manufacturer;
    private Integer sellerId;
}