package com.only4.application.validater;

import com.only4.application.queries.tag.TagExistsByIdQry;
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
@Constraint(validatedBy = {TagExists.validator.class})
public @interface TagExists {

    String message() default "标签不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validator implements
            ConstraintValidator<TagExists, Long> {

        @Override
        public boolean isValid(Long tagId, ConstraintValidatorContext constraintValidatorContext) {
            return Mediator.queries().send(TagExistsByIdQry.Request.builder()
                    .tagId(tagId)
                    .build()).isExists();
        }
    }
}
