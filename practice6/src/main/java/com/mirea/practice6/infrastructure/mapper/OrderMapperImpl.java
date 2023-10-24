package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.OrderMapper;
import com.mirea.practice6.infrastructure.db.entity.OrderDB;

@Mapper(componentModel = "spring")
public interface OrderMapperImpl extends OrderMapper<OrderDB> {
}