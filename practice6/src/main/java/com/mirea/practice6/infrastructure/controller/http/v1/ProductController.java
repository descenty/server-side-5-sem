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

import com.mirea.practice6.infrastructure.schema.in.ProductCreateDTO;
import com.mirea.practice6.infrastructure.schema.out.ProductDTO;
import com.mirea.practice6.infrastructure.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public record ProductController(ProductService productService) {
    @GetMapping("")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable UUID id) {
        return productService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        UUID id = productService.create(productCreateDTO);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        return productService.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
