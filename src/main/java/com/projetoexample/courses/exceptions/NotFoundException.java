package com.projetoexample.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends EntityNotFoundException {
  public NotFoundException(String entityName, Long id) {
    super(String.format("%s com id %d não encontrado", entityName, id));
  }
}
