package com.tamal.springboottutorialone.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //create payload containing exception in detail
        ApiException apiException=new ApiException(e.getMessage(),e,
                HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        // return exception entity
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);

    }
}
