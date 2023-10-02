package com.mirea.practice5.washingMachine;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mirea.practice5.washingMachine.schema.WashingMachineCreate;

@Mapper(componentModel = "spring")
public interface WashingMachineMapper {
    WashingMachine toEntity(WashingMachineCreate WashingMachineCreate);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    WashingMachine update(@MappingTarget WashingMachine WashingMachine, WashingMachineCreate WashingMachineCreate);

}