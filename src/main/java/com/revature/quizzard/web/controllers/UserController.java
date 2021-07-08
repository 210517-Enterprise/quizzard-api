package com.revature.quizzard.web.controllers;

import com.revature.quizzard.dtos.Credentials;
import com.revature.quizzard.dtos.Principal;
import com.revature.quizzard.entities.User;
import com.revature.quizzard.services.UserService;
import com.revature.quizzard.util.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Secured(allowedRoles = {"Admin", "Dev"})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/id/{id}")
    public User getUserById(@PathVariable @Min(0) int id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "/confirmation")
    public void confirmUserAccount(@RequestParam @Min(0) int userId) {
        userService.confirmAccount(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewUser(@RequestBody @Valid User newUser) {
        userService.register(newUser);
    }

    @PostMapping(path = "/authentication", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Principal authenticateUser(@RequestBody @Valid Credentials credentials, HttpServletResponse response) {
        Principal principal = userService.authenticate(credentials.getUsername(), credentials.getPassword());
        response.setHeader("quizzard-token", principal.getToken());
        return principal;
    }

}
