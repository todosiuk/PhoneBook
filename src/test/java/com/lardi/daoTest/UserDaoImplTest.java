package com.lardi.daoTest;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class UserDaoImplTest {

	@Autowired
	UserDaoImpl userDao;

	@Test
	@Transactional
	public void saveTest() {
		User user = new User();
		user.setUserlogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		Assert.assertNotNull(user);

	}

	@Test
	@Transactional
	public void readTest() {
		User user = new User();
		user.setUserlogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
		List<User> userList = userDao.read();
		Assert.assertEquals("login", userList.get(0).getUserlogin());
		Assert.assertEquals("password", userList.get(0).getUserPassword());

	}

}
