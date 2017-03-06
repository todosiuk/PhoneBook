package com.lardi.validatorTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import com.lardi.validator.LoginValidator;

public class LoginValidatorTest {

	private String loginRus = "Логин";
	private String loginEng = "login";
	private String loginWithSpecialCharacter = "login&";
	private String loginWithNumeral = "login45";

	@Test
	public void testIsValid() {
		boolean resultEng = LoginValidator.isValid(loginEng);
		
		Assert.assertTrue(resultEng);
	}

	@Test
	public void testIsNotValid() {
		boolean resultRus = LoginValidator.isValid(loginRus);
		boolean resultWithSpecialCharacter = LoginValidator.isValid(loginWithSpecialCharacter);
		boolean resultWithNumeral = LoginValidator.isValid(loginWithNumeral);
		
		assertFalse(resultRus);
		assertFalse(resultWithSpecialCharacter);
		assertFalse(resultWithNumeral);
	}
}
