package com.mirea.practice6.core.mapper;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.schema.in.CartCreateDTO;
import com.mirea.practice6.core.schema.out.CartDTO;

public interface CartMapper<E extends Cart<CP>, CP extends CartProduct>
        extends EntityMapper<E, CartDTO, CartCreateDTO> {
}