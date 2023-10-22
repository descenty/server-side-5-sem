package com.mirea.practice6.core.service;

import java.util.Optional;
import java.util.UUID;

import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.entity.Entity;
import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.exception.OutOfStockException;
import com.mirea.practice6.core.mapper.CartProductMapper;
import com.mirea.practice6.core.repository.CartProductRepository;
import com.mirea.practice6.core.repository.ProductRepository;
import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.core.schema.out.CartProductDTO;

public class CartProductService
        extends CRUDService<CartProduct, UUID, CartProductDTO, CartProductCreateDTO, CartProductMapper> {
    private final ProductRepository productRepository;

    public CartProductService(CartProductRepository cartProductRepository, CartProductMapper mapper,
            ProductRepository productRepository) {
        super(cartProductRepository, mapper);
        this.productRepository = productRepository;
    }

    public Optional<UUID> create(UUID cartId, CartProductCreateDTO createDTO) throws OutOfStockException {
        Product product = productRepository.findById(createDTO.productId()).get();
        if (product.getStockQuantity() < createDTO.quantity())
            throw new OutOfStockException(product);
        CartProduct cartProduct = new CartProduct(cartId, createDTO.productId(), createDTO.quantity());
        return Optional.of(crudRepository.save(cartProduct)).map(Entity::getId);
    }

    @Override
    public Optional<CartProductDTO> update(UUID id, CartProductCreateDTO cartProductCreateDTO)
            throws OutOfStockException {
        Product product = productRepository.findById(cartProductCreateDTO.productId()).get();
        if (product.getStockQuantity() < cartProductCreateDTO
                .quantity())
            throw new OutOfStockException(product);
        return super.update(id, cartProductCreateDTO);
    }
}
