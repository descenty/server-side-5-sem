package com.mirea.practice6.core.usecase.cart;

import java.util.UUID;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.repository.CartCRUDRepository;
import com.mirea.practice6.core.usecase.CRUDUseCase;

public class CartCRUDUseCase extends CRUDUseCase<Cart, UUID> {
    public CartCRUDUseCase(CartCRUDRepository cartCRUDRepository) {
        super(cartCRUDRepository);
    }
}
