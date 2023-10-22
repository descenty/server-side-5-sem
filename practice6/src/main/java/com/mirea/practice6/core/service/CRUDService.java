package com.mirea.practice6.core.service;

import java.util.List;
import java.util.Optional;

import com.mirea.practice6.core.entity.Entity;
import com.mirea.practice6.core.mapper.EntityMapper;
import com.mirea.practice6.core.repository.CRUDRepository;

public class CRUDService<E extends Entity<ID>, ID, DTO, CreateDTO, M extends EntityMapper<E, DTO, CreateDTO>> {
    protected CRUDRepository<E, ID> crudRepository;
    protected M mapper;

    protected CRUDService(CRUDRepository<E, ID> crudRepository, M mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    public List<DTO> getAll() {
        return crudRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    public Optional<DTO> getById(ID id) {
        return crudRepository.findById(id).map(mapper::toDTO);
    }

    public Optional<ID> create(CreateDTO createDTO) {
        return Optional.of(crudRepository.save(mapper.toEntity(createDTO))).map(Entity::getId);
    }

    public Optional<DTO> update(ID id, CreateDTO createDTO) {
        return crudRepository.findById(id).map(entity -> mapper.update(entity, createDTO))
                .map(crudRepository::save)
                .map(mapper::toDTO);
    }

    public Boolean deleteById(ID id) {
        if (crudRepository.findById(id).isPresent()) {
            crudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}