package com.vccorp.hethongthongtin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handlerNotFoundException(NotFoundException ex, WebRequest rq){
        return new Response(HttpStatus.NOT_FOUND, ex.getMessage(), 404);
    }

    @ExceptionHandler(ConflictExcpetion.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response handlerConflictException(ConflictExcpetion ex, WebRequest rq){
        return new Response(HttpStatus.CONFLICT, ex.getMessage(), 902);
    }
}
