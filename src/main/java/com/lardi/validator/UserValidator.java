package com.lardi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lardi.model.User;
import com.lardi.service.UserService;

public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {

		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUserLogin().length() < 6 || user.getUserLogin().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userService.findUserByLogin(user.getUserLogin()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getUserPassword().length() < 8 || user.getUserPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
	}

}
