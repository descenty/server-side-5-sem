package com.mirea.practice6.infrastructure.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirea.practice6.core.repository.OrderRepository;
import com.mirea.practice6.infrastructure.db.entity.OrderDB;

public interface OrderJpaRepository extends OrderRepository<OrderDB>, JpaRepository<OrderDB, UUID> {
}
