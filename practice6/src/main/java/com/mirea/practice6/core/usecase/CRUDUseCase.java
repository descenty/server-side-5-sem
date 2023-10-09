package com.mirea.practice6.core.usecase;

import java.util.List;
import java.util.Optional;

import com.mirea.practice6.core.repository.CRUDRepository;

public class CRUDUseCase<E, ID> {
    protected CRUDRepository<E, ID> crudRepository;

    public CRUDUseCase(CRUDRepository<E, ID> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<E> getAll() {
        return crudRepository.getAll();
    }

    public Optional<E> getById(ID id) {
        return crudRepository.getById(id);
    }

    public ID create(E entity) {
        return crudRepository.create(entity);
    }

    public boolean deleteById(ID id) {
        return crudRepository.deleteById(id);
    }
}