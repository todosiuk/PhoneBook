package com.lardi.validator;

public class PhoneValidator {

	public static boolean isValid(String phoneField) {

		if (phoneField == null) {
			return false;
		}
		if (phoneField
				.matches("^( +)?((\\+?3|8) ?)?((\\(\\d{3}\\))|(\\d{3}))?( )?(\\d{3}[\\- ]?\\d{2}[\\- ]?\\d{2})( +)?$"))
			return true;
		else
			return false;
	}

}
