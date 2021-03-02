package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {

    static HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException(final String reason) {
        super(STATUS, reason);
    }
}
