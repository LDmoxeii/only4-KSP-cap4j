package com.only4.application.validater;

import com.only4.application.queries.role.RoleExistsByIdQry;
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
@Constraint(validatedBy = {RoleExists.validator.class})
public @interface RoleExists {

    String message() default "角色不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validator implements
            ConstraintValidator<RoleExists, Long> {

        @Override
        public boolean isValid(Long roleId, ConstraintValidatorContext constraintValidatorContext) {
            return Mediator.queries().send(RoleExistsByIdQry.Request.builder()
                    .roleId(roleId)
                    .build()).isExists();
        }
    }
}
