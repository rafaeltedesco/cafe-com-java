package com.minhaempresa.petshop.exceptions.throwables;

public class NotFoundException extends RuntimeException {

    public <T> NotFoundException(Class<T> cls, long id) {
        super(String.format("%s: not found with id %d", cls.getSimpleName(), id));
    }
}
