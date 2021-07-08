package com.revature.quizzard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.quizzard.util.RegexUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data @NoArgsConstructor
@Entity @Table(name = "app_users")
public class User {

    @Id @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @Pattern(regexp = RegexUtil.PASSWORD_REGEX)
    @Column(nullable = false)
    private String password;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Role role;

    @Column(name = "confirmed", columnDefinition = "boolean default false")
    private boolean accountConfirmed;

    @CreationTimestamp
    @Column(name = "registration_datetime", updatable = false, nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime registrationDateTime;

    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    private List<Flashcard> userFlashcards;

    public User(@NotEmpty String username, @Pattern(regexp = RegexUtil.PASSWORD_REGEX) String password,
                @Email String email, @NotEmpty String firstName, @NotEmpty String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        role = Role.BASIC_USER;
        accountConfirmed = false;
    }

    public User(@NotEmpty String username, @Pattern(regexp = RegexUtil.PASSWORD_REGEX) String password,
                @Email String email, @NotEmpty String firstName, @NotEmpty String lastName, @NotNull Role role) {
        this(username, password, email, firstName, lastName);
        this.role = role;
        accountConfirmed = false;
    }

    @JsonIgnore
    public boolean isAdminOrDev() {
        return this.role == Role.ADMIN || this.role == Role.DEV;
    }

}
