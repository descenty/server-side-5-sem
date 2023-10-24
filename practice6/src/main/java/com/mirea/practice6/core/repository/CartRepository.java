package com.mirea.practice6.core.repository;

import java.util.UUID;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.entity.CartProduct;

public interface CartRepository<E extends Cart<CP>, CP extends CartProduct> extends CRUDRepository<E, UUID> {
}
