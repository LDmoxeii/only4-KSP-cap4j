package com.only4.application.validater.member;

import com.only4.domain.aggregates.member.Member;
import com.only4.domain.aggregates.member.meta.MemberSchema;
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
@Constraint(validatedBy = MemberUniquePhone.Validator.class)
public @interface MemberUniquePhone {
    String message() default "手机号已绑定";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<MemberUniquePhone, String> {
        @Override
        public boolean isValid(String memberPhone, ConstraintValidatorContext context) {
            return !Mediator.repositories().exists(JpaPredicate.bySpecification(Member.class,
                    MemberSchema.specify(member ->
                            member.phone().equal(memberPhone
                            ))
            ));
        }
    }
}
