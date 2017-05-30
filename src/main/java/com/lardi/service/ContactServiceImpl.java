package com.lardi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lardi.model.Contact;
import com.lardi.model.Users;
import com.lardi.repository.ContactRepository;
import com.lardi.repository.UserRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(Integer idUser, Contact contact) {
		Users user = userRepository.getOne(idUser);
		contact.setUser(user);
		contactRepository.saveAndFlush(contact);
	}

	@Override
	public void delete(Integer idContact) {
		contactRepository.delete(idContact);
	}

	@Override
	public List<Contact> getAll() {
		return contactRepository.findAll();
	}

	@Override
	public Contact editContact(Contact contact) {
		return contactRepository.saveAndFlush(contact);
	}

}
