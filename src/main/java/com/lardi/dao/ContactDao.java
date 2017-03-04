package com.lardi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lardi.model.Contact;

@Repository
@Transactional
public class ContactDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Contact contact) {
		entityManager.persist(contact);
	}

	public void delete(Integer contactId) {
		Contact contact = entityManager.find(Contact.class, contactId);
		entityManager.remove(contact);
	}

	public void update(Contact contact) {
		entityManager.merge(contact);
	}

	public List<Contact> read() {
		String query = "SELECT c FROM Contact c";
		TypedQuery<Contact> contactList = entityManager.createQuery(query, Contact.class);
		return contactList.getResultList();
	}

	public List<Contact> search(Integer userId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contact> query = cb.createQuery(Contact.class);
		Root<Contact> supplyRoot = query.from(entityManager.getMetamodel().entity(Contact.class));
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (userId != null) {
			predicates.add(cb.equal(supplyRoot.get("user").get("userId"), userId));
		}
		if (!predicates.isEmpty()) {
			query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			query.select(supplyRoot);
		}
		return entityManager.createQuery(query).getResultList();

	}
}
