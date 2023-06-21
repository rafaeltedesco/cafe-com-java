package com.minhaempresa.petshop.exceptions.throwables;

public class UnprocessableEntityException extends RuntimeException {

    public <T> UnprocessableEntityException(Class<T> cls) {
        super(String.format("%s: unprocessable", cls.getSimpleName()));
    }
}
