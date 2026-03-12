package com.tochratana.learnSpring.dto;

public record ProductResponse(
        String code,
        String name,
        Integer price,
        String description
) {
}
