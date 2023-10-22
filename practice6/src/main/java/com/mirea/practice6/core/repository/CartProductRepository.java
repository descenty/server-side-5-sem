package com.mirea.practice6.core.repository;

import java.util.UUID;

import com.mirea.practice6.core.entity.CartProduct;

public interface CartProductRepository extends CRUDRepository<CartProduct, UUID> {
}