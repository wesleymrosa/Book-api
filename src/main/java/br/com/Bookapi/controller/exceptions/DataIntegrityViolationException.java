package br.com.Bookapi.controller.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityViolationException(String cause) {
        super(cause);
    }
}
