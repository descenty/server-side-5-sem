package com.mirea.practice6.core.mapper;

import com.mirea.practice6.core.entity.OrderProduct;
import com.mirea.practice6.core.schema.in.OrderProductCreateDTO;
import com.mirea.practice6.core.schema.out.OrderProductDTO;

public interface OrderProductMapper<E extends OrderProduct>
        extends EntityMapper<E, OrderProductDTO, OrderProductCreateDTO> {
}
