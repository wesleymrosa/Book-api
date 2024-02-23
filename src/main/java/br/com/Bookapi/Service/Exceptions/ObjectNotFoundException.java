package br.com.Bookapi.Service.Exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVesionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}