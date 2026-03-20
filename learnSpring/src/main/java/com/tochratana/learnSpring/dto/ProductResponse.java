package com.tochratana.learnSpring.dto;

import lombok.Builder;

@Builder
public record ProductResponse(
        String code,
        String name,
        Integer price,
        Integer qty,
        String description,
        Boolean isAvailable,
        String categoryName
) {
}
