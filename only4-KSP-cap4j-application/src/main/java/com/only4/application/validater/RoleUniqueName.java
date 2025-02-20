package com.only4.application.validater;

import com.only4.application.queries.role.RoleExistsByNameQry;
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
@Constraint(validatedBy = {RoleUniqueName.validator.class})
public @interface RoleUniqueName {

    String message() default "已存在同名角色";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validator implements
            ConstraintValidator<RoleUniqueName, String> {

        @Override
        public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
            return !Mediator.queries().send(RoleExistsByNameQry.Request.builder()
                    .name(name)
                    .build()).isExists();
        }
    }
}

