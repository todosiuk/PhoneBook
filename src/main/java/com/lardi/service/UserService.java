package com.lardi.service;

import java.util.Collection;
import java.util.Optional;
import com.lardi.model.User;
import com.lardi.model.UserCreateForm;

public interface UserService {

	Optional<User> getUserById(int id);

	Optional<User> getUserByLogin(String login);

	Collection<User> getAllUsers();

	User create(UserCreateForm form);

}
