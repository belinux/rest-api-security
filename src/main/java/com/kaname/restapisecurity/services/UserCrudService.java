package com.kaname.restapisecurity.services;

import com.kaname.restapisecurity.domain.User;

import java.util.Optional;

/**
 * User security operations like login and logout, and CRUD operations on {@link User}.
 *
 * @author kaname
 */
public interface UserCrudService {

    User save(User user);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);
}
