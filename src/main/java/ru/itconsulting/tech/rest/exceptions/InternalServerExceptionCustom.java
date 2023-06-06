package ru.itconsulting.tech.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerExceptionCustom extends RuntimeException {
    public InternalServerExceptionCustom(String message) {
        super(message);
    }
}
