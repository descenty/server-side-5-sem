package com.mirea.practice6.infrastructure.db.entity;

import java.util.List;
import java.util.UUID;

import com.mirea.practice6.core.entity.Cart;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Setter
@Table(name = "cart")
public class CartDB extends Cart {
    @Id
    private UUID id;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CartProductDB> products;
}
