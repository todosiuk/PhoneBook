package com.lardi.validatorTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lardi.app.PhoneBookTest;
import com.lardi.validator.PhoneValidator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneBookTest.class)
public class PhoneValidatorTest {

	private String phone1 = "89261234567";
	private String phone2 = "+38(066)8175615";

	@Test
	@Transactional
	public void testIsValid() {
		boolean result = PhoneValidator.isValid(phone1);
		assertTrue(result);
	}

	@Test
	@Transactional
	public void testIsNotValid() {
		boolean result = PhoneValidator.isValid(phone2);
		assertFalse(result);
	}
}
