package com.example.webfluxplaylist.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(exceptionDto, new HttpHeaders(), exceptionDto.getStatus());
    }

    @ExceptionHandler(WebClientResponseException.BadRequest.class)
    public final ResponseEntity<Object> handleBadRequestExceptions(Exception exception, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(exceptionDto, new HttpHeaders(), exceptionDto.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(exceptionDto, new HttpHeaders(), exceptionDto.getStatus());
    }

}
