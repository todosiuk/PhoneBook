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
import com.lardi.dao.UserDaoImpl;
import com.lardi.model.Contact;
import com.lardi.model.User;
import com.lardi.service.ContactServiceImpl;
import com.lardi.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class UserServiceImplTest {

	@Autowired
	UserDaoImpl userDao;

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
	public void authorizationTrueTest() {
		String login = "login";
		String password = "password";
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		userService.authorization(login, password);
		String returnLogin = userService.authorization(login, password);
		Assert.assertEquals(login, returnLogin);
	}

	@Test
	@Transactional
	public void authorizationLoginFalseTest() {
		String login = "epic1234";
		String password = "password";
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		String returnLogin = userService.authorization(login, password);
		Assert.assertNull(returnLogin);
	}

	@Test
	@Transactional
	public void authorizationPasswordFalseTest() {
		String login = "login";
		String password = "pasword";
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		userService.authorization(login, password);
		String returnLogin = userService.authorization(login, password);
		Assert.assertNull(returnLogin);
	}

	@Test
	@Transactional
	public void getUserIdTrueTest() {
		String login = "login";
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		List<User> userList = userService.read();
		Integer userId = userService.getUserId(login);
		Assert.assertEquals(userId, userList.get(0).getUserId());
	}

	@Test
	@Transactional
	public void getUserIdFalseTest() {
		String login = "login1";
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		Integer userId = userService.getUserId(login);
		Assert.assertNull(userId);
	}
}