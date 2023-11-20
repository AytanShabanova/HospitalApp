package com.example.hospitalmanagementsystem.exception;

import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NullPointExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseDto<?>nullException(){
      return   ResponseDto.builder().httpStatus(HttpStatus.NOT_FOUND).message("Data tapilmadi").build();
    }
}
