package com.revature.quizzard.repos;

import com.revature.quizzard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
    Set<User> findUsersByRole(String role);
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    @Query(value = "update User set accountConfirmed = true where id = :id")
    void confirmAccount(int id);

}
