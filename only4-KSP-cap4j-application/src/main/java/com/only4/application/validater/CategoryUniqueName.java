package com.only4.application.validater;

import com.only4.application.queries.category.CategoryUniqueNameQry;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.netcorepal.cap4j.ddd.Mediator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = CategoryUniqueName.Validator.class)
public @interface CategoryUniqueName {
    String message() default "同名标签已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<CategoryUniqueName, String> {
        @Override
        public boolean isValid(String categoryName, ConstraintValidatorContext context) {
            return !Mediator.queries().send(CategoryUniqueNameQry.Request.builder()
                    .categoryName(categoryName)
                    .build()).isExists();
        }
    }
}
