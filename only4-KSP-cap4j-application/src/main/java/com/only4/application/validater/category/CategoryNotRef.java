package com.only4.application.validater.category;

import com.only4.domain.aggregates.category.Category;
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
@Constraint(validatedBy = CategoryNotRef.Validator.class)
public @interface CategoryNotRef {

    String message() default "分类不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<CategoryNotRef, Long> {
        @Override
        public boolean isValid(Long categoryId, ConstraintValidatorContext context) {
            return Mediator.repositories()
                    .findOne(JpaPredicate.byId(Category.class, categoryId))
                    .map(category -> category.getRefCount() == 0)
                    .orElseThrow(() -> new IllegalArgumentException("RefCount异常"));
        }
    }
}
