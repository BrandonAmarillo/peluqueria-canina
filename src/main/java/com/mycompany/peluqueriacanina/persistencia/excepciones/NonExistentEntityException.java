package com.mycompany.peluqueriacanina.persistencia.excepciones;

public class NonExistentEntityException extends Exception {
    public NonExistentEntityException(String message) {
        super(message);
    }

    public NonExistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
