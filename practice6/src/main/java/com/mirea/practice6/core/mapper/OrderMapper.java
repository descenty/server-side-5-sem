package com.mirea.practice6.core.mapper;

import com.mirea.practice6.core.entity.Order;
import com.mirea.practice6.core.schema.in.OrderCreateDTO;
import com.mirea.practice6.core.schema.out.OrderDTO;

public interface OrderMapper<E extends Order> extends EntityMapper<E, OrderDTO, OrderCreateDTO> {
}
