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

	public List<Contact> getContacts(String login, String password) {
		List<User> userList = this.read();
		for (User user : userList) {
			if (login == user.getUserLogin() && password == user.getUserPassword()) {
				List<Contact> contactList = contactDao.search(user.getUserId());
				return contactList;
			}
		}
		return null;
	}
}
