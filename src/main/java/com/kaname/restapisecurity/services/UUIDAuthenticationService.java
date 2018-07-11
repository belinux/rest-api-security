package com.kaname.restapisecurity.services;

import com.kaname.restapisecurity.domain.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class UUIDAuthenticationService implements UserAuthenticationService {
    @NonNull
    UserCrudService users;

    @Override
    public Optional<String> login(final String username, final String password) {

        if (users.findByUsername(username).isPresent()){

            final User user = users.findByUsername(username).get();

            if (user.getPassword().equals(password)){
                final String uuid = UUID.randomUUID().toString();

                user.setToken(uuid);
                users.save(user);

                return Optional.of(uuid);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findByToken(final String token) {
        return users.findbyToken(token);
    }

    @Override
    public void logout(final User user) {
        user.setToken(null);
        users.save(user);
    }
}