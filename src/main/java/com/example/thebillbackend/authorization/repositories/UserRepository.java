package com.example.thebillbackend.authorization.repositories;

import com.example.thebillbackend.authorization.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
