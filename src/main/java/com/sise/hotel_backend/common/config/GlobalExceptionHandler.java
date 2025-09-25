package com.sise.hotel_backend.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sise.hotel_backend.common.dto.response.BaseResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDto> handleValidationException(
        MethodArgumentNotValidException ex
    ) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.add("El campo " + error.getField() + " incumple con que "+error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(BaseResponseDto.error("Error de validación", errors));
    }

}
