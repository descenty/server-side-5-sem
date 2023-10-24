package com.mirea.practice6.core.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mirea.practice6.core.entity.Order;
import com.mirea.practice6.core.entity.OrderProduct;
import com.mirea.practice6.core.entity.Product;
import com.mirea.practice6.core.entity.Cart;
import com.mirea.practice6.core.entity.CartProduct;
import com.mirea.practice6.core.exception.OutOfStockException;
import com.mirea.practice6.core.mapper.OrderMapper;
import com.mirea.practice6.core.repository.CartRepository;
import com.mirea.practice6.core.repository.OrderProductRepository;
import com.mirea.practice6.core.repository.OrderRepository;
import com.mirea.practice6.core.repository.ProductRepository;
import com.mirea.practice6.core.schema.in.OrderCreateDTO;
import com.mirea.practice6.core.schema.out.OrderDTO;

@SuppressWarnings("unchecked")
public class OrderService<O extends Order, C extends Cart<CP>, P extends Product, OP extends OrderProduct, CP extends CartProduct>
        extends CRUDService<O, UUID, OrderDTO, OrderCreateDTO, OrderMapper<O>> {
    private final CartRepository<C, CP> cartRepository;
    private final ProductRepository<P> productRepository;
    private final OrderProductRepository<OP> orderProductRepository;

    public OrderService(OrderRepository<O> orderRepository, OrderMapper<O> mapper,
            CartRepository<C, CP> cartRepository, ProductRepository<P> productRepository,
            OrderProductRepository<OP> orderProductRepository) {
        super(orderRepository, mapper);
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

    public Optional<UUID> createByCartId(UUID cartId) throws OutOfStockException {
        List<CP> cartProducts = cartRepository.findById(cartId).get().getProducts();
        for (CartProduct cartProduct : cartProducts) {
            Optional<P> product = productRepository.findById(cartProduct.getProductId());
            if (product.get().getStockQuantity() < cartProduct.getQuantity())
                throw new OutOfStockException(product.get());
        }
        O order = this.repository.save((O) new Order());
        for (CartProduct cartProduct : cartProducts) {
            orderProductRepository.save((OP) new OrderProduct(order.getId(), cartProduct.getProductId(),
                    cartProduct.getQuantity()));
        }
        return Optional.of(order.getId());
    }
}
