package com.lardi.validator;

public class LoginValidator {

	public static boolean isValid(String loginField) {
		if (loginField == null) {
			return false;
		}
		if (loginField.matches("[A-Za-z]*")) {
			return true;
		} else {
			return false;
		}
	}
}
