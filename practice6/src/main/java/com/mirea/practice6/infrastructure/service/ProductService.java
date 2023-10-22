package com.mirea.practice6.infrastructure.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.schema.in.ProductCreateDTO;
import com.mirea.practice6.core.schema.out.ProductDTO;
import com.mirea.practice6.core.service.CRUDService;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;
import com.mirea.practice6.infrastructure.db.repository.ProductRepository;
import com.mirea.practice6.infrastructure.mapper.ProductMapper;

@Service
public class ProductService extends CRUDService<ProductDB, UUID, ProductDTO, ProductCreateDTO, ProductMapper> {
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        super(productRepository, productMapper);
    }
}
