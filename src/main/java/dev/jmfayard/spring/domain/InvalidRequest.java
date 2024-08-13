package dev.jmfayard.spring.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InvalidRequest extends RuntimeException {
    public InvalidRequest(String message) {
        super(message);
    }
}
