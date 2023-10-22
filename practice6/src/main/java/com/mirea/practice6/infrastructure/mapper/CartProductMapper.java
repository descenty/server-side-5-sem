package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.core.schema.out.CartProductDTO;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;

@Mapper(componentModel = "spring")
public interface CartProductMapper extends EntityMapper<CartProductDB, CartProductDTO, CartProductCreateDTO> {
}