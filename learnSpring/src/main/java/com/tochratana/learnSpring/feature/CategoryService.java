package com.tochratana.learnSpring.feature;

import com.tochratana.learnSpring.feature.category.CategoryRequest;
import com.tochratana.learnSpring.feature.category.CategoryResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
}
