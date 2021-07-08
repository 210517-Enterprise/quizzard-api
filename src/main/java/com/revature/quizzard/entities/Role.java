package com.revature.quizzard.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    ADMIN("Admin"), DEV("Dev"), BASIC_USER("Basic User"),
    PREMIUM_USER("Premium User"), LOCKED("Locked");

    private String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    @JsonValue
    public String toString() {
        return name;
    }

}
