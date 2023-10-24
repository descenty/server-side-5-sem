package com.mirea.practice6.core.repository;

import java.util.UUID;

import com.mirea.practice6.core.entity.Product;

public interface ProductRepository<E extends Product> extends CRUDRepository<E, UUID> {
}
