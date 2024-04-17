package com.Springpro.Springpro.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestException(HttpClientErrorException.BadRequest ex) {
        // Handle 400 Bad Request
        return ResponseEntity.badRequest().body("Bad Request Ayham");
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        // Handle 401 Unauthorized
        return ResponseEntity.status(401).body("Unauthorized Ayham");
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<Object> handleForbiddenException(HttpClientErrorException.Forbidden ex) {
        // Handle 403 Forbidden
        return ResponseEntity.status(403).body("Forbidden Ayham");
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Object> handleNotFoundException(HttpClientErrorException.NotFound ex) {
        // Handle 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerErrorException(HttpServerErrorException.InternalServerError ex) {
        // Handle 500 Internal Server Error
        return ResponseEntity.status(500).body("Internal Server Error Ayham");
    }
}
