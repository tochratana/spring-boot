package com.tochratana.learnSpring.mapper;

import com.tochratana.learnSpring.domain.Product;
import com.tochratana.learnSpring.dto.ProductResponse;

public class ProductMapper {
    public static ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .qty(product.getQty())
                .description(product.getDescription())
                .isAvailable(product.getIsAvailable())
                .categoryName(product.getCategory().getName())
                .build();
    }
}
