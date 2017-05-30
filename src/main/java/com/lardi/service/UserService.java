package com.lardi.service;

import com.lardi.model.Users;

public interface UserService {

	Users findByUsername(String username);

	void save(Users user);

}
