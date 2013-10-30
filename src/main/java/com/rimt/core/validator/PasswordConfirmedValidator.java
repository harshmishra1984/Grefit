package com.rimt.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmedValidator implements ConstraintValidator<ConfirmPassword, String> {

    protected String password;

	public void initialize(ConfirmPassword password) {
		this.password = password.message();
		
	}

	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		return true;
	}

   
}
