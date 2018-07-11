package com.kaname.restapisecurity.services;

import com.kaname.restapisecurity.domain.User;
import com.kaname.restapisecurity.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCrudServiceImp implements UserCrudService {

    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findbyToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
