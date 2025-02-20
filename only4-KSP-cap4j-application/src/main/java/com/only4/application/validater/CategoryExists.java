package com.only4.application.validater;

import com.only4.application.queries.category.CategoryExistsQry;
import org.netcorepal.cap4j.ddd.Mediator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = CategoryExists.Validator.class)
public @interface CategoryExists {
    String message() default "分类不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<CategoryExists, Long> {
        @Override
        public boolean isValid(Long categoryId, ConstraintValidatorContext context) {
            return Mediator.queries().send(CategoryExistsQry.Request.builder()
                    .categoryId(categoryId)
                    .build()).isExists();
        }
    }
}
