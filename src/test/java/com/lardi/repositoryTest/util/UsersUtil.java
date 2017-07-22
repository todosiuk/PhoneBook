package com.lardi.repositoryTest.util;

import com.lardi.model.Users;

public class UsersUtil {

	public static Users createUsers() {
		Users user = new Users();
		user.setUsername("testUser");
		user.setPassword("password");
		user.setFullName("Hose Karera Alvares");
		return user;
	}
}
