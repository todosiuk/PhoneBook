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

	public List<User> findUserByLogin(String login) {
		List<User> user = userDao.findUserByLogin(login);
		return user;
	}

	public boolean aut(String login, String password) {
		boolean access = false;
		List<User> user = this.findUserByLogin(login);
		for (User userList : user) {
			if (userList != null && userList.getUserPassword() == password) {
				access = true;
			}
		}
		return access;
	}
}
