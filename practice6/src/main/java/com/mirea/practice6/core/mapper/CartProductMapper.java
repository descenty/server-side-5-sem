package com.mirea.practice6.core.mapper;

import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.core.schema.out.CartProductDTO;

public interface CartProductMapper<E extends CartProduct>
        extends EntityMapper<E, CartProductDTO, CartProductCreateDTO> {
}
