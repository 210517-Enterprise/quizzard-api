package com.revature.quizzard.services;

import com.revature.quizzard.dtos.Principal;
import com.revature.quizzard.util.exceptions.*;
import com.revature.quizzard.entities.Role;
import com.revature.quizzard.entities.User;
import com.revature.quizzard.repos.UserRepository;
import com.revature.quizzard.web.intercom.AuthServiceClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepository userRepo;
    private AuthServiceClient authClient;

    @Autowired
    public UserService(UserRepository repo, AuthServiceClient authClient) {
        this.userRepo = repo;
        this.authClient = authClient;
    }

    @Transactional(readOnly = true)
    public User getUserById(@Min(0) int id) {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void register(@Valid User newUser) {

        try {
            getUserByUsername(newUser.getUsername());
            throw new ResourcePersistenceException("Username is already in use!");
        } catch (ResourceNotFoundException rnfe) {
            newUser.setRole(Role.BASIC_USER);
            newUser.setAccountConfirmed(true); // bypass account confirmation for now
            userRepo.save(newUser);
        }

    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {

        List<User> users;

        users = (List<User>) userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    @Transactional(readOnly = true)
    public Set<User> getUsersByRole(Role role) {

        Set<User> users;

        users = userRepo.findUsersByRole(role.toString());

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    public void confirmAccount(int userId) {
        userRepo.confirmAccount(userId);
    }

    public SortedSet<User> sortUsers(String sortCriterion, Set<User> usersForSorting) {

        SortedSet<User> users = new TreeSet<>(usersForSorting);

        switch (sortCriterion.toLowerCase()) {
            case "username":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getUsername, String::compareTo))));
                break;
            case "first":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getFirstName, String::compareTo))));
                break;
            case "last":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getLastName, String::compareTo))));
                break;
            case "role":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getRole, Enum::compareTo))));
                break;
            default:
                throw new InvalidRequestException();

        }

        return users;

    }

    public Principal authenticate(String username, String password) {

        User authUser = userRepo.findUserByUsernameAndPassword(username, password).orElseThrow(AuthenticationException::new);

        if (authUser.isAccountConfirmed()) {
            Principal principal = new Principal(authUser);
            String token = authClient.generateTokenFromPrincipal(principal);
            principal.setToken(token);
            return principal;
        } else {
            throw new AuthenticationException("Account not confirmed.");
        }

    }

    public void updateProfile(User updatedUser) {

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && persistedUser.get().getId() != updatedUser.getId()) {
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        userRepo.save(updatedUser);

    }

}
