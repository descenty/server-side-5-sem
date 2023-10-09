package com.mirea.practice6.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.repository.CartCRUDRepository;
import com.mirea.practice6.core.usecase.cart.CartCRUDUseCase;
import com.mirea.practice6.infrastructure.db.repository.CartRepository;
import com.mirea.practice6.infrastructure.mapper.CartMapper;
import com.mirea.practice6.infrastructure.schema.out.CartDTO;

@Service
public class CartService extends CartCRUDUseCase {
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        super(cartRepository);
        this.cartMapper = cartMapper;
    }

    @Override
    public List<CartDTO> getAll() {
        return super.getAll().stream().map(cartMapper::toDTO).toList();
    }

    @Override
    public Optional<Cart> getById(UUID id) {
        // TODO Auto-generated method stub
        return super.getById(id);
    }

    @Override
    public UUID create(Cart entity) {
        return super.create(entity);
    }

    @Override
    public boolean deleteById(UUID id) {
        // TODO Auto-generated method stub
        return super.deleteById(id);
    }
}
