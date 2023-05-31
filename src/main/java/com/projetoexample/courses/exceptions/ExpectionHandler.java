package com.projetoexample.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExpectionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<?> handleEntityNotFoundException(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionMessage(e.getMessage()));
  }
}
