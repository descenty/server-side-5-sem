package com.mirea.practice6.core.service;

import java.util.UUID;

import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.mapper.ProductMapper;
import com.mirea.practice6.core.repository.ProductRepository;
import com.mirea.practice6.core.schema.in.ProductCreateDTO;
import com.mirea.practice6.core.schema.out.ProductDTO;

public class ProductService<E extends Product>
        extends CRUDService<E, UUID, ProductDTO, ProductCreateDTO, ProductMapper<E>> {
    public ProductService(ProductRepository<E> repository, ProductMapper<E> mapper) {
        super(repository, mapper);
    }
}
