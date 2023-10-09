package com.mirea.practice6.infrastructure.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.infrastructure.schema.in.CartCreateDTO;
import com.mirea.practice6.infrastructure.schema.out.CartDTO;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartCreateDTO toEntity(Cart cart);

    CartDTO toDTO(Cart company);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Cart update(@MappingTarget Cart cart, CartCreateDTO cartCreateDTO);
}