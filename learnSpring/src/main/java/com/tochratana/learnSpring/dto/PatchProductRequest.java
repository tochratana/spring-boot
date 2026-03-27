package com.tochratana.learnSpring.dto;

public record PatchProductRequest(
        String name,
        String description,
        Integer price,
        Integer qty,
        Integer categoryId,
        Boolean isAvailable
) {
}
