package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.CartProductMapper;
import com.mirea.practice6.infrastructure.db.entity.CartProductDB;

@Mapper(componentModel = "spring")
public interface CartProductMapperImpl extends CartProductMapper<CartProductDB> {
}