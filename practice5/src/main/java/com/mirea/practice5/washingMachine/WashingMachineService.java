package com.mirea.practice5.washingMachine;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mirea.practice5.washingMachine.schema.WashingMachineCreate;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WashingMachineService {
    private final WashingMachineRepository washingMachineRepository;
    private final WashingMachineMapper washingMachineMapper;

    public List<WashingMachine> getAll() {
        return washingMachineRepository.findAll();
    }

    public Optional<WashingMachine> getById(UUID id) {
        return washingMachineRepository.findById(id);
    }

    @Transactional
    public Optional<UUID> create(WashingMachineCreate WashingMachineCreate) {
        return Optional.of(washingMachineMapper.toEntity(WashingMachineCreate)).map(washingMachineRepository::save).map(WashingMachine::getId);
    }

    @Transactional
    public Optional<WashingMachine> partialUpdate(UUID id, WashingMachineCreate WashingMachineCreate) {
        return washingMachineRepository.findById(id).map(WashingMachine -> washingMachineMapper.update(WashingMachine, WashingMachineCreate)).map(washingMachineRepository::save);
    }

    @Transactional
    public boolean delete(UUID id) {
        return washingMachineRepository.findById(id).map(WashingMachine -> {
            washingMachineRepository.delete(WashingMachine);
            return true;
        }).orElse(false);
    }

}