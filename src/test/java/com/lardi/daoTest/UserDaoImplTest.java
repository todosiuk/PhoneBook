package com.lardi.daoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.lardi.app.PhoneBookTest;
import com.lardi.dao.UserDaoImpl;
import com.lardi.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class UserDaoImplTest {

	//@Autowired
	//private TestEntityManager entityManager;

	@Autowired
	UserDaoImpl userDao;

	@Test
	public void save() {
		User user = new User();
		user.setUserlogin("login");
		user.setUserPassword("password");
		user.setFullName("Fiomyfio");
		userDao.create(user);
	}
}
