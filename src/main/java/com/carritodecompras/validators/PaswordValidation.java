package com.carritodecompras.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * implementacion de la logicca de la anotacion ConstraintValidator.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since
 *
 */
public class PaswordValidation implements ConstraintValidator<Password, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		
		return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
	}

}
