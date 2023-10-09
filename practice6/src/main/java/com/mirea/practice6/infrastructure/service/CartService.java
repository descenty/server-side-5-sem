package com.mirea.practice6.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.usecase.CRUDUseCase;
import com.mirea.practice6.infrastructure.db.entity.CartDB;
import com.mirea.practice6.infrastructure.db.repository.CartRepository;
import com.mirea.practice6.infrastructure.mapper.CartMapper;
import com.mirea.practice6.infrastructure.schema.out.CartDTO;

@Service
public class CartService extends CRUDUseCase<CartDB, UUID> {
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        super(cartRepository);
        this.cartMapper = cartMapper;
    }

    public List<CartDTO> getAll() {
        return super.getAllEntities().stream().map(cartMapper::toDTO).toList();
    }

    public Optional<CartDTO> getById(UUID id) {
        return super.getEntityById(id).map(cartMapper::toDTO);
    }

    public UUID create(Cart entity) {
        return super.createEntity(entity);
    }

    public boolean deleteById(UUID id) {
        // TODO Auto-generated method stub
        return super.deleteEntityById(id);
    }
}
