package br.com.ar.arinvest.controller.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

    private final StandardError standardError;

    public ControllerExceptionHandler(StandardError standardError) {
        this.standardError = standardError;
    }

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(
            ControllerNotFoundException exception, HttpServletRequest request) {

        standardError.setTimestamp(Instant.now());
        standardError.setStatus(NOT_FOUND.value());
        standardError.setError("Resource not found");
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(NOT_FOUND).body(standardError);
    }
}
