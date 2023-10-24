package com.mirea.practice6.core.mapper;

import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.schema.in.ProductCreateDTO;
import com.mirea.practice6.core.schema.out.ProductDTO;

public interface ProductMapper<E extends Product> extends EntityMapper<E, ProductDTO, ProductCreateDTO> {
}
