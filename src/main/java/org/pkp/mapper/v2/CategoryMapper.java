package org.pkp.mapper.v2;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.pkp.dto.v2.request.CategoryRequest;
import org.pkp.dto.v2.response.CategoryResponse;
import org.pkp.entity.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toResponse(Category category);
    List<CategoryResponse> toResponseList(List<Category> categorys);
    Category toEntity(CategoryRequest categoryDto);
    @Mapping(target = "categoryID", ignore = true) // Don't let the DTO change the ID
    void updateEntityFromDto(CategoryRequest dto, @MappingTarget Category entity);
}
