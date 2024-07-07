package com.example.internationalization.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AlreadyExistException extends RuntimeException {
    private final Integer statusCode;

    public AlreadyExistException() {
        this.statusCode = HttpStatus.CONFLICT.value();
    }
}
