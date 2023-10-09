package com.mirea.practice6.core.usecase.product;

import java.util.UUID;

import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.repository.ProductCRUDRepository;
import com.mirea.practice6.core.usecase.CRUDUseCase;

public class ProductCRUDUseCase extends CRUDUseCase<Product, UUID> {
    public ProductCRUDUseCase(ProductCRUDRepository productCRUDRepository) {
        super(productCRUDRepository);
    }
}
