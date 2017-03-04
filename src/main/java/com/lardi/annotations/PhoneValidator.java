package com.lardi.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone phone) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext cvc) {

		return false;
	}

}
