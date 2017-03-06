package com.lardi.daoTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void createTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserlogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		Assert.assertNotNull(contact);
	}

	@Test
	public void readTest() {
		User user = new User();
		user.setFullName("Fiofio");
		user.setUserlogin("login");
		user.setUserPassword("password");
		userDao.create(user);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		int userId = user.getUserId();
		contactDao.create(userId, contact);
		List<Contact> list = contactDao.read();
		Assert.assertEquals(1, list.size());
		Assert.assertEquals("name", list.get(0).getContactName());
	}
	
	
	
	

}
