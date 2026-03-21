package com.tochratana.learnSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppGlobalException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(
            ResponseStatusException e
    ){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(e.getStatusCode().toString())
                .code(e.getStatusCode().value())
                .message(e.getReason())
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(errorResponse, e.getStatusCode());

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidation(MethodArgumentNotValidException e) {

        List<FieldResponse> fieldResponses = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            FieldResponse fieldResponse = FieldResponse.builder()
                    .field(error.getField())
                    .message(error.getDefaultMessage())
                    .build();

            fieldResponses.add(fieldResponse);
        });

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed")
                .timestamp(Instant.now())
                .errors(fieldResponses)
                .build();
    }
}
