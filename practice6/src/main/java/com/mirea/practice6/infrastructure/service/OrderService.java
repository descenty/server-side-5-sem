package com.mirea.practice6.infrastructure.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.schema.in.OrderCreateDTO;
import com.mirea.practice6.core.schema.out.OrderDTO;
import com.mirea.practice6.core.service.CRUDService;
import com.mirea.practice6.infrastructure.db.entity.OrderDB;
import com.mirea.practice6.infrastructure.db.repository.OrderRepository;
import com.mirea.practice6.infrastructure.mapper.OrderMapper;

@Service
public class OrderService extends CRUDService<OrderDB, UUID, OrderDTO, OrderCreateDTO, OrderMapper> {
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        super(orderRepository, orderMapper);
    }
}
