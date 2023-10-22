package com.mirea.practice6.infrastructure.db.entity;

import java.util.UUID;

import com.mirea.practice6.core.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductDB extends Product {
    @Id
    private UUID id;
}
