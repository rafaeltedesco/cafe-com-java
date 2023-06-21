package com.minhaempresa.petshop.exceptions.throwables;

public class ThrowableFactory {

    public static <T> NotFoundException createNotFoundException(Class<T> cls, Long id) {
        return new NotFoundException(cls, id);
    }

    public static <T> UnprocessableEntityException createUnprocessableException(Class<T> cls) {
        return new UnprocessableEntityException(cls);
    }

}
