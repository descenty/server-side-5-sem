package com.mirea.practice6.core.service;

import java.util.List;
import java.util.Optional;

import com.mirea.practice6.core.entity.Entity;
import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.core.repository.CRUDRepository;

public class CRUDService<E extends Entity<ID>, ID, DTO, CreateDTO, M extends EntityMapper<E, DTO, CreateDTO>> {
    protected CRUDRepository<E, ID> repository;
    protected M mapper;

    protected CRUDService(CRUDRepository<E, ID> crudRepository, M mapper) {
        this.repository = crudRepository;
        this.mapper = mapper;
    }

    protected CRUDService() {
    }

    public List<DTO> getAll() {
        System.out.println(repository.findAll().get(0));
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public Optional<DTO> getById(ID id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public Optional<ID> create(CreateDTO createDTO) {
        return Optional.of(repository.save(mapper.toEntity(createDTO))).map(Entity::getId);
    }

    public Optional<DTO> update(ID id, CreateDTO createDTO) {
        return repository.findById(id).map(entity -> mapper.update(entity, createDTO))
                .map(repository::save)
                .map(mapper::toDTO);
    }

    public Boolean deleteById(ID id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}