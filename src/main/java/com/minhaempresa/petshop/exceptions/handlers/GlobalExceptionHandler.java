package com.minhaempresa.petshop.exceptions.handlers;

import com.minhaempresa.petshop.exceptions.throwables.NotFoundException;
import com.minhaempresa.petshop.exceptions.throwables.UnprocessableEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleRunTimeException(RuntimeException ex) {
        String message = ex.getMessage();
        System.out.println(message);
        Map<String, String> response = new HashMap<>() {
            {
                put("message", ex.getMessage());
                put("statusCode", "500");
                put("trace", ex.getStackTrace().toString());
                put("cause", ex.getCause().toString());
            }
        };
        return response;
    }
}
