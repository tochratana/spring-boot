package com.tochratana.learnSpring.mapper;

import com.tochratana.learnSpring.domain.Product;
import com.tochratana.learnSpring.dto.ProductResponse;
import com.tochratana.learnSpring.dto.UpdateProductRequest;

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


    public static void toUpdateProductRequest(UpdateProductRequest updateProductRequest, Product product){

        product.setName(updateProductRequest.name());
        product.setDescription(updateProductRequest.description());
        product.setQty(updateProductRequest.qty());
        product.setPrice(updateProductRequest.price());

    }
}
