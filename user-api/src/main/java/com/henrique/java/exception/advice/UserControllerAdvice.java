package com.henrique.java.exception.advice;

import org.henrique.java.backend.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.henrique.java.backend.Exception.UserErrorException;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.henrique.java.controller")
public class UserControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserErrorException.class)
    public ErrorDTO handleUserNotFound(UserErrorException userErrorException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage(userErrorException.getMessage());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
