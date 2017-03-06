package com.lardi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lardi.dao.ContactDaoImpl;
import com.lardi.dao.UserDaoImpl;
import com.lardi.model.Contact;

@Service
public class ContactServiceImpl implements ContactService<Contact, String> {

	@Autowired
	private UserDaoImpl userDao;

	@Autowired
	private ContactDaoImpl contactDao;

	@Override
	public void create(Integer userId, Contact contact) {
		contactDao.create(userId, contact);
	}

	@Override
	public void delete(Integer contactId) {
		contactDao.delete(contactId);

	}

	@Override
	public void update(Contact contact) {
		contactDao.update(contact);

	}

	@Override
	public List<Contact> read() {
		return contactDao.read();
	}

	@Override
	public List<Contact> search(Integer userId) {
		return contactDao.search(userId);
	}

}
