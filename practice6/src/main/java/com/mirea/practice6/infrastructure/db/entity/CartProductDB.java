package com.mirea.practice6.infrastructure.db.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.mirea.practice6.core.entity.CartProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "cart_product")
@ToString
public class CartProductDB extends CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    @JsonIgnore
    private CartDB cart;

    @Column(name = "cart_id", nullable = true)
    @JsonIgnore
    private UUID cartId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "product_id")
    @JsonIncludeProperties({ "id", "name", "description", "price", "stockQuantity" })
    private ProductDB product;

    @Column(name = "product_id", nullable = true, insertable = false, updatable = false)
    @JsonIgnore
    private UUID productId;

    @Column(nullable = false)
    private Byte quantity;

    public CartProductDB() {
        super();
    }

    public CartProductDB(UUID cartId, UUID productId, Byte quantity) {
        super(cartId, productId, quantity);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CartDB getCart() {
        return cart;
    }

    public void setCart(CartDB cart) {
        this.cart = cart;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public ProductDB getProduct() {
        return product;
    }

    public void setProduct(ProductDB product) {
        this.product = product;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }
}
