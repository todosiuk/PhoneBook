package com.lardi.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;


public interface UserDao<User, id extends Serializable> {

	public void create(User user);

	public List<User> read();
}
