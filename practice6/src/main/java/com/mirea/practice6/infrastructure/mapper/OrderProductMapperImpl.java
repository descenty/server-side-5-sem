package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.OrderProductMapper;
import com.mirea.practice6.infrastructure.db.entity.OrderProductDB;

@Mapper(componentModel = "spring")
public interface OrderProductMapperImpl extends OrderProductMapper<OrderProductDB> {
}