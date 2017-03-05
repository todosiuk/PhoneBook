package com.lardi.serviceTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.lardi.app.PhoneBookTest;
import com.lardi.model.User;
import com.lardi.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class UserServiceImplTest {

	@Autowired
	private UserServiceImpl userService;

	@Test
	public void createTest() {
		User user = new User();
		user.setUserlogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);
		Assert.assertNotNull(user);
	}

	@Test
	public void readTest() {
		User user = new User();
		user.setUserlogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userService.create(user);

		List<User> userList = userService.read();

		Assert.assertEquals("Fiomyfio", userList.get(0).getFullName());
		Assert.assertEquals("login", userList.get(0).getUserlogin());
		Assert.assertEquals("password", userList.get(0).getUserPassword());
	}
	
	

}
