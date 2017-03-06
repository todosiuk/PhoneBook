package com.lardi.validatorTest;

import static org.junit.Assert.*;
import org.junit.Test;

import com.lardi.validator.PhoneValidator;

public class PhoneValidatorTest {

	private String phone1 = "89261234567";
	private String phone2 = "+38(066)8175615";

	@Test
	public void testIsValid() {
		boolean result = PhoneValidator.isValid(phone1);
		assertTrue(result);
	}
	
	@Test
	public void testIsNotValid(){
		boolean result = PhoneValidator.isValid(phone2);
		assertFalse(result);
	}
}
