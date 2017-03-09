package com.lardi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lardi.dao.ContactDaoImpl;
import com.lardi.dao.UserDaoImpl;
import com.lardi.model.User;

@Service
public class UserServiceImpl implements UserService<User, String> {

	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private ContactDaoImpl contactDao;

	public void create(User user) {
		userDao.create(user);
	}

	public List<User> read() {
		return userDao.read();
	}

	public User findUserByLogin(String login) {
		User user = userDao.findUserByLogin(login);
		return user;
	}

	public boolean aut(String login, String password) {
		boolean access;
		User user = this.findUserByLogin(login);
		if (user != null && user.getUserPassword() == password) {
			access = true;
		} else {
			access = false;
		}
		return access;
	}
}
