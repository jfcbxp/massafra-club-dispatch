package com.massafra.club.dispatch.exceptions;

import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
public class FidemaxCustomerException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FidemaxCustomerException(String msg) {
        super(msg);
    }
}
