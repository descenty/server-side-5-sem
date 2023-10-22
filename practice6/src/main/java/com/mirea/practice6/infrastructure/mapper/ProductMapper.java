package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.core.schema.in.ProductCreateDTO;
import com.mirea.practice6.core.schema.out.ProductDTO;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDB, ProductDTO, ProductCreateDTO> {
}