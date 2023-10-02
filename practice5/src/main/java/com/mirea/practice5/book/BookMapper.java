package com.mirea.practice5.book;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mirea.practice5.book.schema.BookCreate;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookCreate BookCreate);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Book update(@MappingTarget Book Book, BookCreate BookCreate);

}