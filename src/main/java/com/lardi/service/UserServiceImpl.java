package com.lardi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lardi.dao.ContactDaoImpl;
import com.lardi.dao.UserDaoImpl;
import com.lardi.model.Contact;
import com.lardi.model.User;
import com.lardi.validator.LoginValidator;

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

	public String authorization(String login, String password) {
		List<User> userList = this.read();
		String returnLogin = null;
		for (User user : userList) {
			if (login == user.getUserLogin() && password == user.getUserPassword()) {
				returnLogin = login;
				break;
			}
		}
		return returnLogin;
	}

	public List<Contact> contactList(Integer userId) {
		List<Contact> contactList = contactDao.searchContactsForUser(userId);
		return contactList;
	}

	public Integer getUserId(String userLogin) {
		List<User> userList = this.read();
		for (User user : userList) {
			if (user.getUserLogin() == userLogin) {
				return user.getUserId();
			}
		}
		return null;
	}
}
