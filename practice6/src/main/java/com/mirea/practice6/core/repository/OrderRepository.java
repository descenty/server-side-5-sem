package com.mirea.practice6.core.repository;

import java.util.UUID;

import com.mirea.practice6.core.entity.Order;

public interface OrderRepository<E extends Order> extends CRUDRepository<E, UUID> {
}
