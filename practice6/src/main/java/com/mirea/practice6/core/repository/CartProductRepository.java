package com.mirea.practice6.core.repository;

import java.util.List;
import java.util.UUID;

import com.mirea.practice6.core.entity.CartProduct;

public interface CartProductRepository<E extends CartProduct> extends CRUDRepository<E, UUID> {
    public List<E> findAllByCartId(UUID cartId);

    public void deleteAllByCartId(UUID cartId);
}