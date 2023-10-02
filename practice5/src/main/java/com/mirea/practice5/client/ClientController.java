package com.mirea.practice5.client;

import java.util.List;
import java.util.Optional;

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

import com.mirea.practice5.client.schema.ClientCreate;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return clientService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody ClientCreate clientCreate) {
        Optional<Long> clientId = clientService.create(clientCreate);
        return clientId.isPresent()
                ? ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(clientId.get()).toUri()).build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Client> partialUpdate(@PathVariable Long id, @Valid @RequestBody ClientCreate clientCreate) {
        return clientService.partialUpdate(id, clientCreate).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return clientService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}