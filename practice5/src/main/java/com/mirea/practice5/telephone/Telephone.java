package com.mirea.practice5.telephone;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Telephone {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String title;
        private String type = "electronic";
        private BigDecimal price;
        private Integer batteryCapacity;
        private String manufacturer;
        private Integer sellerId;
}