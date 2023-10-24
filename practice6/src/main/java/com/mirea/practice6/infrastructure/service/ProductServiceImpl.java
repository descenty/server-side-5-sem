package com.mirea.practice6.infrastructure.service;

import org.springframework.stereotype.Service;

import com.mirea.practice6.core.service.ProductService;
import com.mirea.practice6.infrastructure.db.entity.ProductDB;
import com.mirea.practice6.infrastructure.db.repository.ProductJpaRepository;
import com.mirea.practice6.infrastructure.mapper.ProductMapperImpl;

@Service
public class ProductServiceImpl extends ProductService<ProductDB> {

    public ProductServiceImpl(ProductJpaRepository repository, ProductMapperImpl mapper) {
        super(repository, mapper);
    }
}
