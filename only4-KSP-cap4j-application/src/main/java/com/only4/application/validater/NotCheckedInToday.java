package com.only4.application.validater;

import com.only4.application.queries.check_in.NotCheckedInTodayQry;
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
@Constraint(validatedBy = NotCheckedInToday.Validator.class)
public @interface NotCheckedInToday {
    String message() default "今天已签到";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<NotCheckedInToday, Long> {
        @Override
        public boolean isValid(Long memberId, ConstraintValidatorContext context) {
            return Mediator.queries().send(NotCheckedInTodayQry.Request.builder()
                    .memberId(memberId)
                    .build()).isExists();
        }
    }
}
