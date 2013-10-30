package com.rimt.core.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {PasswordConfirmedValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ConfirmPassword {
    String message() default "{errors.signup.password.needConfirm}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
