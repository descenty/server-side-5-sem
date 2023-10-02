package com.mirea.practice5.client;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mirea.practice5.client.schema.ClientCreate;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientCreate ClientCreate);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Client update(@MappingTarget Client Client, ClientCreate ClientCreate);

}