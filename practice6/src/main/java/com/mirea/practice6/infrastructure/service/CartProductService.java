package com.mirea.practice6.infrastructure.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.core.schema.out.CartProductDTO;
import com.mirea.practice6.core.service.CRUDService;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;
import com.mirea.practice6.infrastructure.db.repository.CartProductRepository;
import com.mirea.practice6.infrastructure.mapper.CartProductMapper;

@Service
public class CartProductService extends CRUDService<CartProductDB, UUID, CartProductDTO, CartProductCreateDTO, CartProductMapper> {
    public CartProductService(CartProductRepository cartProductRepository, CartProductMapper cartProductMapper) {
        super(cartProductRepository, cartProductMapper);
    }
}
