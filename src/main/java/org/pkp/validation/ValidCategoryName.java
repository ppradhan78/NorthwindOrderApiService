package org.pkp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoryNameValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCategoryName {

    String message() default "Category exists in a system";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}