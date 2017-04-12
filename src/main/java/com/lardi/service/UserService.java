package com.lardi.service;

import java.util.Optional;
import com.lardi.model.User;
import com.lardi.model.UserCreateForm;

public interface UserService {

	Optional<User> getUserById(int id);

	Optional<User> getUserByLogin(String login);

	User create(UserCreateForm form);

}
