package com.lardi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lardi.dao.ContactDao;
import com.lardi.dao.UserDao;
import com.lardi.model.Contact;
import com.lardi.model.User;

public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ContactDao contactDao;
	public void create (User user) {
		userDao.create(user);
	}
	public List <User> read (){
		return userDao.read();
	}
	public List<Contact> authorization(String login,String password, Integer id){
		List <User> userList=this.read();
		for (User user:userList){
			if (login==user.getUserlogin()&&password==user.getUserPassword()){
				List<Contact>contactList=contactDao.search(id);
				return contactList;
										
			}
			}
		return null;
		
	}
}
