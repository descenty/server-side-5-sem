package com.mirea.practice5.washingMachine;

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

import com.mirea.practice5.washingMachine.schema.WashingMachineCreate;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/washing-machines")
@RequiredArgsConstructor
public class WashingMachineController {
    private final WashingMachineService washingMachineService;

    @GetMapping("")
    public List<WashingMachine> getAll() {
        return washingMachineService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WashingMachine> getById(@PathVariable Long id) {
        return washingMachineService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody WashingMachineCreate washingMachineCreate) {
        Optional<Long> washingMachineId = washingMachineService.create(washingMachineCreate);
        return washingMachineId.isPresent()
                ? ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(washingMachineId.get()).toUri()).build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WashingMachine> partialUpdate(@PathVariable Long id,
            @Valid @RequestBody WashingMachineCreate washingMachineCreate) {
        return washingMachineService.partialUpdate(id, washingMachineCreate).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return washingMachineService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}