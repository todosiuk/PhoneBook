package com.lardi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.lardi.model.User;
import com.lardi.service.UserService;

@Component
public class UserValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {

		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLogin", "NotEmpty");
		if (user.getUserLogin().length() < 6 || user.getUserLogin().length() > 32) {
			errors.rejectValue("userLogin", "Size.userForm.userLogin");
		}
		if (userService.findUserByLogin(user.getUserLogin()) != null) {
			errors.rejectValue("userLogin", "Duplicate.userForm.userLogin");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "NotEmpty");
		if (user.getUserPassword().length() < 8 || user.getUserPassword().length() > 32) {
			errors.rejectValue("userPassword", "Size.userForm.userPassword");
		}
	}

}
