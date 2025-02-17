package com.only4.application.validater.member;

import com.only4.domain.aggregates.member.Member;
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
@Constraint(validatedBy = MemberNotCheckIn.Validator.class)
public @interface MemberNotCheckIn {
    String message() default "当天已签到";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<MemberNotCheckIn, Long> {
        @Override
        public boolean isValid(Long memberId, ConstraintValidatorContext context) {
            return !Mediator.repositories()
                    .findOne(JpaPredicate.byId(Member.class, memberId))
                    .map(Member::isCheckIn)
                    .orElseThrow(RuntimeException::new);
        }
    }
}
