package com.massafra.club.dispatch.exceptions;

import lombok.Getter;

@Getter
public class IntegrationInternalException extends RuntimeException {

    private final String message;
    private final Integer status;

    private static final long serialVersionUID = 1L;

    public IntegrationInternalException(String message, Integer status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
