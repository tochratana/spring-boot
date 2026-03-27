package com.tochratana.learnSpring.dto;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        String description,
        Integer price,
        Integer qty
) {
}
