package com.only4.application.validater;

import com.only4.application.queries.admin_user.AdminUserExistsByNameQry;
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
@Constraint(validatedBy = {AdminUserUniqueName.validator.class})
public @interface AdminUserUniqueName {

    String message() default "该用户已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validator implements ConstraintValidator<AdminUserUniqueName, String> {

        @Override
        public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
            return !Mediator.queries().send(AdminUserExistsByNameQry.Request.builder()
                    .name(name)
                    .build()).isExists();
        }
    }
}
