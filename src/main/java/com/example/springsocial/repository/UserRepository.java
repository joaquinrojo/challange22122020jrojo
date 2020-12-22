package com.example.springsocial.repository;

import com.example.springsocial.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsid(String usid);

    Boolean existsByEmail(String email);

}
