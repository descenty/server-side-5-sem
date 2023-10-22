package com.mirea.practice6.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.usecase.CRUDUseCase;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.repository.CartRepository;
import com.mirea.practice6.infrastructure.mapper.CartMapper;
import com.mirea.practice6.infrastructure.schema.in.CartCreateDTO;
import com.mirea.practice6.infrastructure.schema.out.CartDTO;

@Service
public class CartService extends CRUDUseCase<CartDB, UUID, CartDTO, CartCreateDTO, CartMapper> {
    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        super(cartRepository, cartMapper);
    }
}
