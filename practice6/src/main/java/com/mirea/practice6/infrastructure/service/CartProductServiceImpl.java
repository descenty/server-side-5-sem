package com.mirea.practice6.infrastructure.service;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.service.CartProductService;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;
import com.mirea.practice6.infrastructure.db.repository.CartProductJpaRepository;
import com.mirea.practice6.infrastructure.db.repository.ProductJpaRepository;
import com.mirea.practice6.infrastructure.mapper.CartProductMapperImpl;

@Service
public class CartProductServiceImpl extends CartProductService<CartProductDB, ProductDB> {

        public CartProductServiceImpl(CartProductJpaRepository cartProductRepository,
                        CartProductMapperImpl mapper,
                        ProductJpaRepository productRepository) {
                super(cartProductRepository, mapper, productRepository);
        }
}
