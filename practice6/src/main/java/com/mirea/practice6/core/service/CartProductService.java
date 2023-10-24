package com.mirea.practice6.core.service;

import java.util.List;
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

@SuppressWarnings("unchecked")
public class CartProductService<CP extends CartProduct, P extends Product>
        extends CRUDService<CP, UUID, CartProductDTO, CartProductCreateDTO, CartProductMapper<CP>> {
    private final CartProductRepository<CP> repository;
    private final ProductRepository<P> productRepository;

    public CartProductService(CartProductRepository<CP> cartProductRepository, CartProductMapper<CP> mapper,
            ProductRepository<P> productRepository) {
        this.repository = cartProductRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<CartProductDTO> findAllByCartId(UUID cartId) {
        return repository.findAllByCartId(cartId).stream().map(mapper::toDTO).toList();
    }

    public Optional<UUID> create(UUID cartId, CartProductCreateDTO createDTO) throws OutOfStockException {
        Product product = productRepository.findById(createDTO.productId()).get();
        if (product.getStockQuantity() < createDTO.quantity())
            throw new OutOfStockException(product);
        CP cartProduct = (CP) new CartProduct(cartId, createDTO.productId(), createDTO.quantity());
        return Optional.of(repository.save(cartProduct)).map(Entity::getId);
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
