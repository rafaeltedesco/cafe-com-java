package com.estudojava.petshopapi.exceptionsHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.estudojava.petshopapi.dtos.exceptions.ExceptionDTO;

@RestControllerAdvice
public class InvalidArgumentException  {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ExceptionDTO handleArgumentNotValid(MethodArgumentNotValidException ex) {
    String errorMessage = ex.getFieldError() != null ? ex.getFieldError().getDefaultMessage() : "Unknown Error";
    return  new ExceptionDTO(errorMessage);
  }
}
