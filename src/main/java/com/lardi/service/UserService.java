package com.lardi.service;

import java.io.Serializable;
import java.util.List;

import com.lardi.model.Contact;
import com.lardi.model.User;

public interface UserService<User, id extends Serializable> {
	
	public List <User> read ();
	
	public List<User> authorization(String login,String password);

}
