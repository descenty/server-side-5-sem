package com.mirea.practice5.book;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private String type;
    private Integer price;
    private Integer sellerId;
}