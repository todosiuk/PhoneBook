package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import model.Contact;

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
	
	

}
