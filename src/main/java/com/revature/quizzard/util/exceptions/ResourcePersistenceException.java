package com.revature.quizzard.util.exceptions;

public class ResourcePersistenceException extends QuizzardException {

    public ResourcePersistenceException() {
        super("Resource not persisted!");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }

}
