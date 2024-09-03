package com.example.thebillbackend.config;

import com.example.thebillbackend.core.dtos.ErrorDto;
import com.example.thebillbackend.core.exceptions.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleRestException(AppException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorDto(ex.getMessage()));
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(ex.getMessage()));
    }
}
