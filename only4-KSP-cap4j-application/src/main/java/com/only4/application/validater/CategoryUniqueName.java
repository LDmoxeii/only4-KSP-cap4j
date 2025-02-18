package com.only4.application.validater;

import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.category.meta.CategorySchema;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;

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
@Constraint(validatedBy = CategoryUniqueName.Validator.class)
public @interface CategoryUniqueName {
    String message() default "同名标签已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<CategoryUniqueName, String> {
        @Override
        public boolean isValid(String categoryName, ConstraintValidatorContext context) {
            return !Mediator.repositories()
                    .exists(JpaPredicate.bySpecification(Category.class,
                            CategorySchema.specify(category ->
                                    category.name().equal(categoryName)
                            )
                    ));
        }
    }
}
