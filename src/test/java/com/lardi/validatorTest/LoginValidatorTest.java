package com.lardi.validatorTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lardi.app.PhoneBookTest;
import com.lardi.validator.LoginValidator;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class LoginValidatorTest {

	private String loginRus = "Логин";
	private String loginEng = "login";
	private String loginWithSpecialCharacter = "login&";
	private String loginWithNumeral = "login45";

	@Test
	@Transactional
	public void testIsValid() {
		boolean resultEng = LoginValidator.isValid(loginEng);
		
		Assert.assertTrue(resultEng);
	}

	@Test
	@Transactional
	public void testIsNotValid() {
		boolean resultRus = LoginValidator.isValid(loginRus);
		boolean resultWithSpecialCharacter = LoginValidator.isValid(loginWithSpecialCharacter);
		boolean resultWithNumeral = LoginValidator.isValid(loginWithNumeral);
		
		assertFalse(resultRus);
		assertFalse(resultWithSpecialCharacter);
		assertFalse(resultWithNumeral);
	}
}
