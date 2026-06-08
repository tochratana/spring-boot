package com.tochratana.learnSpring.feature.category;

public record CategoryRequest(
        String name,
        String description,
        String icon
) {
}
