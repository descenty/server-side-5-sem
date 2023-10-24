package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.ProductMapper;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;

@Mapper(componentModel = "spring")
public interface ProductMapperImpl extends ProductMapper<ProductDB> {
}