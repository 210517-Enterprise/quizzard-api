package com.revature.quizzard.util.exceptions;

public class InvalidRequestException extends QuizzardException {

    public InvalidRequestException() {
        super("Invalid request made!");
    }

    public InvalidRequestException(String message) {
        super(message);
    }

}
