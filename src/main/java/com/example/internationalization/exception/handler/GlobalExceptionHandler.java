package com.example.internationalization.exception.handler;

import com.example.internationalization.dto.response.ErrorResponse;
import com.example.internationalization.exception.AlreadyExistException;
import com.example.internationalization.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.internationalization.util.LocalizationUtil.getLocalizedMessageByKey;
import static com.example.internationalization.util.LocalizationUtil.getLocalizedMessageByStatusCode;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundExceptionHandler(NotFoundException exception, HttpServletRequest request) {
        var message = getLocalizedMessageByStatusCode("i18n/error", exception.getStatusCode());
        var response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss")))
                .status(exception.getStatusCode())
                .message(message)
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> alreadyExistExceptionHandler(AlreadyExistException exception, HttpServletRequest request) {
        var message = getLocalizedMessageByStatusCode("i18n/error", exception.getStatusCode());
        var response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss")))
                .status(exception.getStatusCode())
                .message(message)
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exceptionHandler(Exception exception, HttpServletRequest request) {
        var message = getLocalizedMessageByKey("i18n/error", "unexpected.exception");
        var response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss")))
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(message)
                .path(request.getRequestURI())
                .build();

        return response;
    }
}
