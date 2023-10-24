package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.CartMapper;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;

@Mapper(componentModel = "spring")
public interface CartMapperImpl extends CartMapper<CartDB, CartProductDB> {
}