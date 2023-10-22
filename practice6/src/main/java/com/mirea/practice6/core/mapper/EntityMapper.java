package com.mirea.practice6.core.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;

public interface EntityMapper<E, DTO, CreateDTO> {
    E toEntity(CreateDTO createDTO);

    DTO toDTO(E entity);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    E update(@MappingTarget E entity, CreateDTO createDTO);
}