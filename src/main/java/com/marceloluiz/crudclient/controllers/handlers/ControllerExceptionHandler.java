package com.marceloluiz.crudclient.controllers.handlers;

import com.marceloluiz.crudclient.dto.CustomError;
import com.marceloluiz.crudclient.dto.ValidationError;
import com.marceloluiz.crudclient.services.exceptions.DatabaseException;
import com.marceloluiz.crudclient.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = CustomError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> resourceNotFound(DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = CustomError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> resourceNotFound(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = ValidationError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Invalid Data")
                .path(request.getRequestURI())
                .build();

        for(FieldError field : e.getBindingResult().getFieldErrors()){
            error.addError(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }
}
