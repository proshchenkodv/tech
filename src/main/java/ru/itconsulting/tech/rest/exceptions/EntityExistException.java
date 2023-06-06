package ru.itconsulting.tech.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityExistException extends RuntimeException {
    public EntityExistException() {
        super();
    }

    public EntityExistException(String message) {
        super(message);
    }
}
