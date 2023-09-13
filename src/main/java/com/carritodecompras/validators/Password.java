package com.carritodecompras.validators;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
/**
 *antotacion personalizada para la validacion de contraseña en formulario de registro de cuenta.  
 *  
 *@author Mateo j. Rodriguez Chico
 *
 *@since
 *
 */
@Documented
@Target(FIELD)
@Constraint(validatedBy = PaswordValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

	String message() default "Contraseña inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};	
}
