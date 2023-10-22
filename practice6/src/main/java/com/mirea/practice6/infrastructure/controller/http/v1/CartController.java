package com.mirea.practice6.infrastructure.controller.http.v1;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mirea.practice6.infrastructure.schema.in.CartCreateDTO;
import com.mirea.practice6.infrastructure.schema.out.CartDTO;
import com.mirea.practice6.infrastructure.service.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public record CartController(CartService cartService) {
    @GetMapping("")
    public List<CartDTO> getAll() {
        return cartService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getById(@PathVariable UUID id) {
        return cartService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody CartCreateDTO cartCreateDTO) {
        UUID id = cartService.create(cartCreateDTO);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        return cartService.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
