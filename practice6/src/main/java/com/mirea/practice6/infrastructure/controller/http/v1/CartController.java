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

import com.mirea.practice6.core.schema.in.CartCreateDTO;
import com.mirea.practice6.core.schema.out.CartDTO;
import com.mirea.practice6.infrastructure.db.repository.CartJpaRepository;
import com.mirea.practice6.infrastructure.service.CartServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public record CartController(CartServiceImpl cartService, CartJpaRepository cartJpaRepository) {
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
        return cartService.create(cartCreateDTO)
                .map(id -> ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(id).toUri()).build())
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        return cartService.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
