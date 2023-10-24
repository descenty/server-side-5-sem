package com.mirea.practice6.infrastructure.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirea.practice6.core.repository.OrderProductRepository;
import com.mirea.practice6.infrastructure.db.entity.OrderProductDB;

@Repository
public interface OrderProductJpaRepository
        extends OrderProductRepository<OrderProductDB>, JpaRepository<OrderProductDB, UUID> {
}
