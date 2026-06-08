package com.tochratana.learnSpring.feature.category;

import com.tochratana.learnSpring.feature.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {

        log.info("Create new Category:{}", categoryRequest);

        Category category = new Category();
        return null;
    }
}
