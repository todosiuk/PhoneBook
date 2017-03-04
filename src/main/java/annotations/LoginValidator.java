package annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<Login, String> {

	@Override
	public void initialize(Login login) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String loginField, ConstraintValidatorContext cvc) {
		if (loginField == null) {
			return false;
		}
		return loginField.matches("/^[A-Za-z]*$/");
	}

}
