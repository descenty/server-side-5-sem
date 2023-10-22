package com.mirea.practice6.infrastructure.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.usecase.CRUDUseCase;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;
import com.mirea.practice6.infrastructure.db.repository.ProductRepository;
import com.mirea.practice6.infrastructure.mapper.ProductMapper;
import com.mirea.practice6.infrastructure.schema.in.ProductCreateDTO;
import com.mirea.practice6.infrastructure.schema.out.ProductDTO;

@Service
public class ProductService extends CRUDUseCase<ProductDB, UUID, ProductDTO, ProductCreateDTO, ProductMapper> {
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        super(productRepository, productMapper);
    }
}
