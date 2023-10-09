package com.mirea.practice6.core.usecase.cartProduct;

import java.util.UUID;

import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.repository.CartProductCRUDRepository;
import com.mirea.practice6.core.usecase.CRUDUseCase;

public class CartProductCRUDUseCase extends CRUDUseCase<CartProduct, UUID> {
    public CartProductCRUDUseCase(CartProductCRUDRepository cartProductCRUDRepository) {
        super(cartProductCRUDRepository);
    }
}
