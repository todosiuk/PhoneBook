package com.lardi.serviceTest;

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
	public void autTestTrue() {
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);
		boolean aut = userService.aut("login", "password");
		Assert.assertEquals(true, aut);
	}

	@Test
	@Transactional
	public void autTestFalse() {
		User user = new User();
		user.setUserLogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);
		boolean aut = userService.aut("login", "pasword");
		Assert.assertEquals(false, aut);
	}
}