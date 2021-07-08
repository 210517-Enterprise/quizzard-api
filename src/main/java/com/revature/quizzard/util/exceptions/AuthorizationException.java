package com.revature.quizzard.util.exceptions;

public class AuthorizationException extends QuizzardException {

    public AuthorizationException() {
        super("You do not have the proper permissions to perform that action!");
    }

}