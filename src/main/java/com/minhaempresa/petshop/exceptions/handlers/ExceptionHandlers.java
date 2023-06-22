package com.minhaempresa.petshop.exceptions.handlers;

import com.minhaempresa.petshop.exceptions.throwables.NotFoundException;
import com.minhaempresa.petshop.exceptions.throwables.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> handleEntityNotFoundException(NotFoundException ex) {
        return new HashMap<>() {
            {
                put("message", ex.getMessage());
                put("statusCode", "404");
            }
        };
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, String> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        return new HashMap<>() {
            {
                put("message", ex.getMessage());
                put("statusCode", "422");
            }
        };
    }
}
