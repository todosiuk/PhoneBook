package com.lardi.dao;

import java.io.Serializable;
import java.util.List;

import com.lardi.model.Contact;

public interface ContactDao<Contact, id extends Serializable> {
	public void create(Integer userId,Contact contact);

	public void delete(Integer contactId);

	public void update(Contact contact);

	public List<Contact> read();

	public List<Contact> search(Integer userId);
}
