package com.tochratana.learnSpring.mapper;

import com.tochratana.learnSpring.domain.Product;
import com.tochratana.learnSpring.dto.ProductResponse;
import com.tochratana.learnSpring.dto.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
//    public static ProductResponse toProductResponse(Product product){
//        return ProductResponse.builder()
//                .code(product.getCode())
//                .name(product.getName())
//                .price(product.getPrice())
//                .qty(product.getQty())
//                .description(product.getDescription())
//                .isAvailable(product.getIsAvailable())
//                .categoryName(product.getCategory().getName())
//                .build();
//    }
//
//
//    public static void toUpdateProductRequest(UpdateProductRequest updateProductRequest, Product product){
//
//        product.setName(updateProductRequest.name());
//        product.setDescription(updateProductRequest.description());
//        product.setQty(updateProductRequest.qty());
//        product.setPrice(updateProductRequest.price());
//
//    }


    @Mapping(source = "category.name", target = "category")
    ProductResponse toProductResponse(Product product);
    void toUpdateProductRequest(UpdateProductRequest updateProductRequest, @MappingTarget Product product);



}
