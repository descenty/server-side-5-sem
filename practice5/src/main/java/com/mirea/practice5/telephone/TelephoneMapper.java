package com.mirea.practice5.telephone;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mirea.practice5.telephone.schema.TelephoneCreate;

@Mapper(componentModel = "spring")
public interface TelephoneMapper {
    Telephone toEntity(TelephoneCreate TelephoneCreate);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Telephone update(@MappingTarget Telephone Telephone, TelephoneCreate TelephoneCreate);

}