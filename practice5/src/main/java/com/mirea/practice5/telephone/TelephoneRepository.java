package com.mirea.practice5.telephone;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, UUID> {
}