package com.mirea.practice6.core.repository;

import java.util.UUID;

import com.mirea.practice6.core.entity.OrderProduct;

public interface OrderProductRepository<E extends OrderProduct> extends CRUDRepository<E, UUID> {
}
