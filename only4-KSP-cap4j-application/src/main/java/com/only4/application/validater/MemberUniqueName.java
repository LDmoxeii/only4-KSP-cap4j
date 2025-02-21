package com.only4.application.validater;

import com.only4.application.queries.member.MemberUniqueNameQry;
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
@Constraint(validatedBy = MemberUniqueName.Validator.class)
public @interface MemberUniqueName {
    String message() default "帐号已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<MemberUniqueName, String> {
        @Override
        public boolean isValid(String memberName, ConstraintValidatorContext context) {
            return !Mediator.queries().send(MemberUniqueNameQry.Request.builder()
                    .memberName(memberName)
                    .build()).isExists();
        }
    }
}
