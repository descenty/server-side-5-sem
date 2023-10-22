package com.mirea.practice6.infrastructure.controller.http.v1;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mirea.practice6.core.exception.OutOfStockException;
import com.mirea.practice6.core.schema.in.CartProductCreateDTO;
import com.mirea.practice6.infrastructure.service.CartProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public record CartProductController(CartProductService service) {
    @PostMapping("/{cartId}/products")
    public ResponseEntity<?> create(@PathVariable UUID cartId, @Valid @RequestBody CartProductCreateDTO createDTO) {
        try {
            return service.create(createDTO)
                    .map(id -> ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                            .buildAndExpand(id).toUri()).build())
                    .orElse(ResponseEntity.badRequest().build());
        } catch (OutOfStockException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{cartId}/products{id}")
    public ResponseEntity<?> update(@PathVariable UUID cartId, @PathVariable UUID id,
            @Valid @RequestBody CartProductCreateDTO createDTO) {
        try {
            return service.update(id, createDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        } catch (OutOfStockException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{cartId}/products/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID cartId, @PathVariable UUID id) {
        return service.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}