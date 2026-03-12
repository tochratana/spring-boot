package com.tochratana.learnSpring.dto;

public record UpdateProduct(
        String name,
        String description,
        Integer price
) {
}
