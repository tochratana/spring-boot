package com.tochratana.learnSpring.exception;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record ErrorResponse(
        String status,
        int code,
        String message,
        Instant timestamp,
        List<FieldResponse> errors
) {
}