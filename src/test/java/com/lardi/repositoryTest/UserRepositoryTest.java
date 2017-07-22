package com.lardi.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.lardi.PhoneBookApplication;
import com.lardi.model.Users;
import com.lardi.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PhoneBookApplication.class })
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void findByUsernamePositiveTest() {
		Users user = this.repository.findByUsername("user1");
		assertThat(user.getUsername()).isEqualTo("user1");
	}

	@Test
	public void findByUsernameNegativeTest() {
		Users user = this.repository.findByUsername("user2");
		Assert.assertNull(user);

	}
}
