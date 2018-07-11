package com.kaname.restapisecurity.repositories;

import com.kaname.restapisecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByToken(String token);
    Optional<User> findByUsername(String username);
}
