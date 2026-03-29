package com.tochratana.learnSpring.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PatchProductRequest(
        @Size(min = 1, max = 100)
        String name,
        String description,

        @Positive
        Integer price,

        @Positive
        Integer qty,

        @Positive
        Integer categoryId,
        Boolean isAvailable
) {
}
