package com.tochratana.learnSpring.feature.category;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/category")
public class CategoryController {

    @PostMapping
    public CategoryResponse createCategory(CategoryRequest categoryRequest){

        return null;
    }
}
