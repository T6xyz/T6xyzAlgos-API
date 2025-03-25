package com.T6xyz_API.T6xyzio.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.T6xyz_API.T6xyzio.exceptions.AppException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorDTO(e.getMessage()));
    }
}