package com.mirea.practice6.infrastructure.service;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.service.OrderService;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;
import com.mirea.practice6.infrastructure.db.entity.OrderDB;
import com.mirea.practice6.infrastructure.db.entity.OrderProductDB;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;
import com.mirea.practice6.infrastructure.db.repository.CartJpaRepository;
import com.mirea.practice6.infrastructure.db.repository.OrderJpaRepository;
import com.mirea.practice6.infrastructure.db.repository.OrderProductJpaRepository;
import com.mirea.practice6.infrastructure.db.repository.ProductJpaRepository;
import com.mirea.practice6.infrastructure.mapper.OrderMapperImpl;

@Service
public class OrderServiceImpl extends OrderService<OrderDB, CartDB, ProductDB, OrderProductDB, CartProductDB> {

    public OrderServiceImpl(OrderJpaRepository orderRepository, OrderMapperImpl mapper,
            CartJpaRepository cartRepository, ProductJpaRepository productRepository,
            OrderProductJpaRepository orderProductRepository) {
        super(orderRepository, mapper, cartRepository, productRepository, orderProductRepository);
    }
}
