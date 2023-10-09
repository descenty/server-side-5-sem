package com.mirea.practice6.infrastructure.controller.http.v1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirea.practice6.infrastructure.schema.out.CartDTO;
import com.mirea.practice6.infrastructure.service.CartService;

@RestController
@RequestMapping("/carts")
public record CartController(CartService cartService) {
    @GetMapping("")
    public List<CartDTO> getAll() {
        return cartService.getAll();
    }
}
