package com.mirea.practice6.infrastructure.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirea.practice6.core.repository.CRUDRepository;
import com.mirea.practice6.infrastructure.db.entity.CartDB;

public interface CartRepository extends CRUDRepository<CartDB, UUID>, JpaRepository<CartDB, UUID> {
}
