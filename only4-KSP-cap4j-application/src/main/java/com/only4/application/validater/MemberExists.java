package com.only4.application.validater;

import com.only4.application.queries.member.MemberExistsQry;
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
@Constraint(validatedBy = MemberExists.Validator.class)
public @interface MemberExists {
    String message() default "用户已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<MemberExists, Long> {
        @Override
        public boolean isValid(Long memberId, ConstraintValidatorContext context) {
            return Mediator.queries().send(MemberExistsQry.Request.builder()
                    .memberId(memberId)
                    .build()).isExists();
        }
    }
}
