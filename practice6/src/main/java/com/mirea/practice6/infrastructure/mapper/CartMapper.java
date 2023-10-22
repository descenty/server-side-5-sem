package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.schema.in.CartCreateDTO;
import com.mirea.practice6.infrastructure.schema.out.CartDTO;

@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CartDB, CartDTO, CartCreateDTO> {
}