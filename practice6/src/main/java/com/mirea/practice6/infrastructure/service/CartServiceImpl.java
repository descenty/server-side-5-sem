package com.mirea.practice6.infrastructure.service;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.service.CartService;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;
import com.mirea.practice6.infrastructure.db.repository.CartJpaRepository;
import com.mirea.practice6.infrastructure.mapper.CartMapperImpl;

@Service
public class CartServiceImpl extends CartService<CartDB, CartProductDB> {
    public CartServiceImpl(CartJpaRepository repository, CartMapperImpl mapper) {
        super(repository, mapper);
    }
}
