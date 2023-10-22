package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.core.schema.in.OrderCreateDTO;
import com.mirea.practice6.core.schema.out.OrderDTO;
import com.mirea.practice6.infrastructure.db.entity.OrderDB;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDB, OrderDTO, OrderCreateDTO> {
}