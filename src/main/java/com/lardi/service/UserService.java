package com.lardi.service;

import com.lardi.model.User;

public interface UserService {

	User findByUsername(String username);

	void save(User user);

}
