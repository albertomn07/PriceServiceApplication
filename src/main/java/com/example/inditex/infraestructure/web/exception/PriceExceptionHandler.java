package com.example.inditex.infraestructure.web.exception;

import com.example.inditex.domain.exceptions.IncorrectParamException;
import com.example.inditex.domain.exceptions.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PriceExceptionHandler {
    @ExceptionHandler(IncorrectParamException.class)
    public ResponseEntity<Object> handleIncorrectParamException(IncorrectParamException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
