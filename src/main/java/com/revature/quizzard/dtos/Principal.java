package com.revature.quizzard.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.quizzard.entities.User;

public class Principal {

    private int id;
    private String username;
    private String role;

    @JsonIgnore
    private String token;

    public Principal() {
        super();
    }

    public Principal(User subject) {
        this.id = subject.getId();
        this.username = subject.getUsername();
        this.role = subject.getRole().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
