package com.lardi.service;

import java.io.Serializable;
import java.util.List;

import com.lardi.model.Contact;
import com.lardi.model.User;

public interface UserService<T, id extends Serializable> {

	public void create(User user);

	public List<User> read();

	public List<Contact> getContacts(String login, String password);

}
