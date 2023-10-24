package com.mirea.practice6.core.service;

import java.util.Optional;
import java.util.UUID;

import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.mapper.CartMapper;
import com.mirea.practice6.core.repository.CartRepository;
import com.mirea.practice6.core.schema.in.CartCreateDTO;
import com.mirea.practice6.core.schema.out.CartDTO;

public class CartService<E extends Cart<CP>, CP extends CartProduct>
        extends CRUDService<E, UUID, CartDTO, CartCreateDTO, CartMapper<E, CP>> {
    public CartService(CartRepository<E, CP> repository, CartMapper<E, CP> mapper) {
        super(repository, mapper);
    }

    @Override
    public Optional<UUID> create(CartCreateDTO createDTO) {
        if (repository.findById(createDTO.userId()).isPresent())
            return Optional.empty();
        repository.save(mapper.toEntity(createDTO));
        return Optional.of(createDTO.userId());
    }
}
