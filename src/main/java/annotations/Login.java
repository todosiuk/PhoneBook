package annotations;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = LoginValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

	String message() default "{Login}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
