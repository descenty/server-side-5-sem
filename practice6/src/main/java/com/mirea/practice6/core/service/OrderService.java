package com.mirea.practice6.core.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mirea.practice6.core.entity.Order;
import com.mirea.practice6.core.entity.OrderProduct;
import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.exception.OutOfStockException;
import com.mirea.practice6.core.mapper.OrderMapper;
import com.mirea.practice6.core.repository.CartRepository;
import com.mirea.practice6.core.repository.OrderProductRepository;
import com.mirea.practice6.core.repository.OrderRepository;
import com.mirea.practice6.core.repository.ProductRepository;
import com.mirea.practice6.core.schema.in.OrderCreateDTO;
import com.mirea.practice6.core.schema.out.OrderDTO;

public class OrderService
        extends CRUDService<Order, UUID, OrderDTO, OrderCreateDTO, OrderMapper> {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderService(OrderRepository orderRepository, OrderMapper mapper,
            CartRepository cartRepository, ProductRepository productRepository,
            OrderProductRepository orderProductRepository) {
        super(orderRepository, mapper);
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

    public Optional<UUID> createByCartId(UUID cartId) throws OutOfStockException {
        List<CartProduct> cartProducts = cartRepository.findById(cartId).get().getProducts();
        for (CartProduct cartProduct : cartProducts) {
            Optional<Product> product = productRepository.findById(cartProduct.getProductId());
            if (product.get().getStockQuantity() < cartProduct.getQuantity())
                throw new OutOfStockException(product.get());
        }
        Order order = this.crudRepository.save(new Order());
        for (CartProduct cartProduct : cartProducts) {
            orderProductRepository.save(new OrderProduct(order.getId(), cartProduct.getProductId(),
                    cartProduct.getQuantity()));
        }
        return Optional.of(order.getId());
    }
}
