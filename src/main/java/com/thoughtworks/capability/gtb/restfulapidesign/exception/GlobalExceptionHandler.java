package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponse> exceptionHandler(IllegalArgumentException ex){
        String message = ex.getMessage();
        int value = HttpStatus.NOT_FOUND.value();
        ExceptionResponse exceptionResponse = new ExceptionResponse(value,message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
