package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.core.schema.in.CartCreateDTO;
import com.mirea.practice6.core.schema.out.CartDTO;
import com.mirea.practice6.infrastructure.db.entity.CartDB;

@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CartDB, CartDTO, CartCreateDTO> {
}