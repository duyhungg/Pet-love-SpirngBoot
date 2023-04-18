package com.stc.petlove.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundAuthenticationException extends AuthenticationException {
    public UserNotFoundAuthenticationException(String message) {
        super(message);
    }
}
