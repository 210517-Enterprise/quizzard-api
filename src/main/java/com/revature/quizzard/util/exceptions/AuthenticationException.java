package com.revature.quizzard.util.exceptions;

public class AuthenticationException extends QuizzardException {

    public AuthenticationException() {
        super("Authentication failed!");
    }

    public AuthenticationException(String message) {
        super(message);
    }

}
