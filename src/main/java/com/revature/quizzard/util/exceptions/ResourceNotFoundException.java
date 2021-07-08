package com.revature.quizzard.util.exceptions;

public class ResourceNotFoundException extends QuizzardException {

    public ResourceNotFoundException() {
        super("No resource(s) found");
    }

}
