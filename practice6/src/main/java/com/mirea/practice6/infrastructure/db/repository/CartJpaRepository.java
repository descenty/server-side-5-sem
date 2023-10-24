package com.mirea.practice6.infrastructure.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirea.practice6.core.repository.CartRepository;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;

@Repository
public interface CartJpaRepository extends CartRepository<CartDB, CartProductDB>, JpaRepository<CartDB, UUID> {
}
