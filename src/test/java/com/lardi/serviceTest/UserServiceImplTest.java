package com.lardi.serviceTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lardi.app.PhoneBookTest;
import com.lardi.model.Contact;
import com.lardi.model.User;
import com.lardi.service.ContactServiceImpl;
import com.lardi.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class UserServiceImplTest {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ContactServiceImpl contactService;

	@Test
	@Transactional
	public void createTest() {
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);
		Assert.assertNotNull(user);
	}

	@Test
	@Transactional
	public void readTest() {
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);

		List<User> userList = userService.read();
		Assert.assertEquals("login", userList.get(0).getUserLogin());
		Assert.assertEquals("password", userList.get(0).getUserPassword());
	}

	@Test
	@Transactional
	public void getContactsTest() {
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);
		User user1 = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user1);
		Contact contact = new Contact("surname", "name", "patronumic", "+38(066)5125985", "044-52-85-87", "Kyiv",
				"fgh@jhg.com", user);
		contact.setUser(user);
		Contact contact1 = new Contact("surname1", "name1", "patronumic1", "+38(066)5125981", "044-52-85-871", "Kyiv1",
				"fgh@jhg.com", user1);
		contactService.create(user1.getUserId(), contact1);
		List<Contact> contactList = contactService.search(user1.getUserId());

		assertEquals("name1", contactList.get(0).getContactName());

	}

}
