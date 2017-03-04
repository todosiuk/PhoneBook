package com.lardi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lardi.model.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.persist(user);
	}

	public List<User> read() {
		String query = "SELECT u FROM User u";
		TypedQuery<User> contactList = entityManager.createQuery(query, User.class);
		return contactList.getResultList();
	}
}
