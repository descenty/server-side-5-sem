package com.mirea.practice5.washingMachine;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WashingMachineRepository extends JpaRepository<WashingMachine, UUID> {
}