package com.lardi.daoTest;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.lardi.app.PhoneBookTest;
import com.lardi.dao.ContactDaoImpl;
import com.lardi.dao.UserDaoImpl;
import com.lardi.model.Contact;
import com.lardi.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class ContactDaoImplTest {

	@Autowired
	UserDaoImpl userDao;

	@Autowired
	ContactDaoImpl contactDao;

	@Test
	@Transactional
	public void createTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserLogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		assertNotNull(contact);
	}

	@Test
	@Transactional
	public void readTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserLogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		List<Contact> list = contactDao.read();
		assertEquals(1, list.size());
		assertEquals("name", list.get(0).getContactName());
	}

	@Test
	@Transactional
	public void deleteTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserLogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		contactDao.delete(contact.getContactId());
		List<Contact> contactList = contactDao.read();
		assertEquals(0, contactList.size());
	}

	@Test
	@Transactional
	public void updateTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserLogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		contact.setContactAddress("Lviv");
		contactDao.update(contact);
		List<Contact> contactList = contactDao.read();
		assertEquals("Lviv", contactList.get(0).getContactAddress());
	}

	@Test
	@Transactional
	public void searchTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserLogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		List<Contact> searchList = contactDao.search(userId);
		assertEquals(1, searchList.size());
		assertEquals("login", searchList.get(0).getUser().getUserLogin());
		assertEquals("+38(066)5125985", searchList.get(0).getContactMobilePhone());
	}

}
