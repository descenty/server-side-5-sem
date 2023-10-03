package com.mirea.practice5.telephone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mirea.practice5.telephone.schema.TelephoneCreate;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/telephones")
@RequiredArgsConstructor
public class TelephoneController {
    private final TelephoneService telephoneService;

    @GetMapping("")
    public List<Telephone> getAll() {
        return telephoneService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telephone> getById(@PathVariable UUID id) {
        return telephoneService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody TelephoneCreate telephoneCreate) {
        Optional<UUID> telephoneId = telephoneService.create(telephoneCreate);
        return telephoneId.isPresent()
                ? ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(telephoneId.get()).toUri()).build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Telephone> partialUpdate(@PathVariable UUID id,
            @RequestBody TelephoneCreate telephoneCreate) {
        return telephoneService.partialUpdate(id, telephoneCreate).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return telephoneService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}