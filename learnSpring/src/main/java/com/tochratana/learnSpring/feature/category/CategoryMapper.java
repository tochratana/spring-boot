package com.tochratana.learnSpring.feature.category;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category fromCategoryRequest (CategoryRequest categoryRequest);
    Category toCategoryResponse (Category category);

}
