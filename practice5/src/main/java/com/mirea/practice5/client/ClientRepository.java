package com.mirea.practice5.client;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}