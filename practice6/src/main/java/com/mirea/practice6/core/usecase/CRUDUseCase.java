package com.mirea.practice6.core.usecase;

import java.util.List;
import java.util.Optional;

import com.mirea.practice6.core.repository.CRUDRepository;

public class CRUDUseCase<Entity, ID> {
    protected CRUDRepository<Entity, ID> crudRepository;

    protected CRUDUseCase(CRUDRepository<Entity, ID> crudRepository) {
        this.crudRepository = crudRepository;
    }

    protected List<Entity> getAllEntities() {
        return crudRepository.findAll();
    }

    protected Optional<Entity> getEntityById(ID id) {
        return crudRepository.findById(id);
    }

    protected ID createEntity(Entity entity) {
        return crudRepository.create(entity);
    }

    protected Boolean deleteEntityById(ID id) {
        if (crudRepository.findById(id).isPresent()) {
            crudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}