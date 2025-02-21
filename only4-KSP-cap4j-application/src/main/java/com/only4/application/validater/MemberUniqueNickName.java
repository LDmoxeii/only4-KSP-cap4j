package com.only4.application.validater;

import com.only4.application.queries.member.MemberUniqueNickNameQry;
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
@Constraint(validatedBy = MemberUniqueNickName.Validator.class)
public @interface MemberUniqueNickName {
    String message() default "帐号已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<MemberUniqueNickName, String> {
        @Override
        public boolean isValid(String nickName, ConstraintValidatorContext context) {
            return !Mediator.queries().send(MemberUniqueNickNameQry.Request.builder()
                    .memberNickName(nickName)
                    .build()).isExists();
        }
    }
}
