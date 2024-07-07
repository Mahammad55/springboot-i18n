package com.example.internationalization.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException {
    private final Integer statusCode;

    public NotFoundException() {
        statusCode = HttpStatus.NOT_FOUND.value();
    }
}
