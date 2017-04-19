package com.lardi.service;

import java.util.List;

import com.lardi.model.Contact;

public interface ContactService {

	void save(Integer idUser, Contact contact);

	void delete(Integer idContact);

	List<Contact> getAll();

	Contact editContact(Contact contact);

}
