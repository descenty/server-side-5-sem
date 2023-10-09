package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.infrastructure.schema.in.ProductCreateDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductCreateDTO toEntity(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Product update(@MappingTarget Product product, ProductCreateDTO productCreateDTO);
}