package br.com.Bookapi.controller.exceptions;

import br.com.Bookapi.Service.Exceptions.ObjectNotFoundException;
import jakarta.servlet.ServletRequest;
import org.hibernate.ObjectDeletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectDeletedException.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
