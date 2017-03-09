package com.lardi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lardi.model.User;

@Service
@Transactional
public class UserDaoImpl implements UserDao<User, String> {

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

	public User findUserByLogin(String userLogin) {
		String query = "select u from User u where u.userLogin = :userLogin";
		TypedQuery<User> user = entityManager.createQuery(query, User.class).setParameter("userLogin", userLogin);
		return user.getSingleResult();
	}
	
	
}