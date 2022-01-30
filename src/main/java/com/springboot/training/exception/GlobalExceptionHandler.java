package com.springboot.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(AddressNotFoundException.class)
        public ResponseEntity<?> addressNotFoundException(AddressNotFoundException ex, WebRequest request){
            ErrorDetails err=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<?> internalServerError(InternalServerError ex, WebRequest request){
        ErrorDetails err=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

