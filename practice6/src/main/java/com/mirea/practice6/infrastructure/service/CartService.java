package com.mirea.practice6.infrastructure.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.schema.in.CartCreateDTO;
import com.mirea.practice6.core.schema.out.CartDTO;
import com.mirea.practice6.core.service.CRUDService;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.repository.CartRepository;
import com.mirea.practice6.infrastructure.mapper.CartMapper;

@Service
public class CartService extends CRUDService<CartDB, UUID, CartDTO, CartCreateDTO, CartMapper> {
    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        super(cartRepository, cartMapper);
    }
}
