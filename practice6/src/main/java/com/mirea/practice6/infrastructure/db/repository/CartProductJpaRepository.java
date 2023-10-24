package com.mirea.practice6.infrastructure.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirea.practice6.core.repository.CartProductRepository;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;

@Repository
public interface CartProductJpaRepository
        extends CartProductRepository<CartProductDB>, JpaRepository<CartProductDB, UUID> {
}
