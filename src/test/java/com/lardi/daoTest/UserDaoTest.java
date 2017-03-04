package com.lardi.daoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lardi.dao.UserDao;
import com.lardi.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void create(){
		User user = new User();
		user.setFullName("FIO");
		user.setUserlogin("vasya");
		user.setUserPassword("11111");
		userDao.create(user);
	}
}
