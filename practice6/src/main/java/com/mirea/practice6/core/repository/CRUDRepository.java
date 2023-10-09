package com.mirea.practice6.core.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<E, ID> {
    public List<E> findAll();

    public Optional<E> findById(ID id);

    public ID create(E entity);

    public void deleteById(ID id);
}