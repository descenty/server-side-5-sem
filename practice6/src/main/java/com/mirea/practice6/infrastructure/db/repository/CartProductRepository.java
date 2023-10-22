package com.mirea.practice6.infrastructure.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirea.practice6.core.repository.CRUDRepository;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;

public interface CartProductRepository extends CRUDRepository<CartProductDB, UUID>, JpaRepository<CartProductDB, UUID> {
}
