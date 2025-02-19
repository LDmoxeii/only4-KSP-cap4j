package com.only4.application.validater;

import com.only4.domain.aggregates.tag.Tag;
import com.only4.domain.aggregates.tag.meta.TagSchema;
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
@Constraint(validatedBy = TagUniqueName.Validator.class)
public @interface TagUniqueName {
    String message() default "已存在同名标签";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<TagUniqueName, String> {
        @Override
        public boolean isValid(String tagName, ConstraintValidatorContext context) {
            return !Mediator.repositories()
                    .exists(JpaPredicate.bySpecification(Tag.class,
                            TagSchema.specify(schema ->
                                    schema.name().equal(tagName)
                            )
                    ));
        }
    }
}
