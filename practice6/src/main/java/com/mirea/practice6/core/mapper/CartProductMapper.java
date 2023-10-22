package com.mirea.practice6.core.mapper;

import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.core.schema.out.CartProductDTO;

public interface CartProductMapper extends EntityMapper<CartProduct, CartProductDTO, CartProductCreateDTO> {
}
