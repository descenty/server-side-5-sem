package com.mirea.practice6.core.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.exception.OutOfStockException;
import com.mirea.practice6.core.mapper.CartProductMapper;
import com.mirea.practice6.core.repository.CartProductRepository;
import com.mirea.practice6.core.repository.ProductRepository;
import com.mirea.practice6.core.schema.in.CartProductChangeDTO;
import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.core.schema.out.CartProductDTO;

public class CartProductService<CP extends CartProduct, P extends Product>
        extends CRUDService<CP, UUID, CartProductDTO, CartProductCreateDTO, CartProductMapper<CP>> {
    private final CartProductRepository<CP> repository;
    private final ProductRepository<P> productRepository;

    public CartProductService(CartProductRepository<CP> cartProductRepository, CartProductMapper<CP> mapper,
            ProductRepository<P> productRepository) {
        super(cartProductRepository, mapper);
        this.repository = cartProductRepository;
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    public List<CartProductDTO> findAllByCartId(UUID cartId) {
        return repository.findAllByCartId(cartId).stream().map(mapper::toDTO).toList();
    }

    public Optional<UUID> create(UUID cartId, CartProductCreateDTO createDTO)
            throws OutOfStockException {
        P product = productRepository.findById(createDTO.productId()).get();
        if (product.getStockQuantity() < createDTO.quantity())
            throw new OutOfStockException(product);
        CartProductCreateDTO cartProductCreateDTO = new CartProductCreateDTO(cartId, createDTO.productId(),
                createDTO.quantity());
        return Optional.of(repository.save(mapper.toEntity(cartProductCreateDTO)).getId());
    }

    public Optional<CartProductDTO> update(UUID id, CartProductChangeDTO cartProductChangeDTO)
            throws OutOfStockException {
        try {
            CP cartProduct = repository.findById(id).get();
            P product = productRepository.findById(cartProduct.getProductId()).get();
            if (product.getStockQuantity() < cartProductChangeDTO.quantity())
                throw new OutOfStockException(product);
            return super.update(id,
                    new CartProductCreateDTO(cartProduct.getCartId(), cartProduct.getProductId(),
                            cartProductChangeDTO.quantity()));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public void clear(UUID cartId) {
        repository.deleteAllByCartId(cartId);
    }
}
