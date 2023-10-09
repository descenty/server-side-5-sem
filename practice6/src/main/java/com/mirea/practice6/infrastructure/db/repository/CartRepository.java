package com.mirea.practice6.infrastructure.db.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirea.practice6.core.repository.CartCRUDRepository;
import com.mirea.practice6.infrastructure.db.entity.CartDB;

public interface CartRepository extends CartCRUDRepository, JpaRepository<CartDB, UUID> {
}
