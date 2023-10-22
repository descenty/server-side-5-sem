package com.mirea.practice6.core.repository;

import java.util.UUID;

import com.mirea.practice6.core.entity.Product;

public interface ProductRepository extends CRUDRepository<Product, UUID> {
}
