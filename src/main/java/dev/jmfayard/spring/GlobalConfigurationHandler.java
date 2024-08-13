package dev.jmfayard.spring;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalConfigurationHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleJsonException(HttpServletRequest req, HttpMessageNotReadableException ex) {
        var message = ex.getRootCause().getMessage();
        return new ErrorInfo(req.getRequestURI(), message);
    }
}

