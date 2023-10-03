package com.mirea.practice5.book;

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
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String title;
        private String author;
        private String type = "book";
        private BigDecimal price;
        private Integer sellerId;
}