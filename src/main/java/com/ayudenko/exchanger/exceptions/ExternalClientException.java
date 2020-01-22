package com.ayudenko.exchanger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ExternalClientException extends RuntimeException {
    public ExternalClientException() {
        super();
    }

    public ExternalClientException(String message) {
        super(message);
    }
}
