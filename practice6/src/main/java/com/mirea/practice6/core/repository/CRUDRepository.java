package com.mirea.practice6.core.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<E, ID> {
    public List<E> getAll();

    public Optional<E> getById(ID id);

    public ID create(E entity);

    public boolean deleteById(ID id);
}
