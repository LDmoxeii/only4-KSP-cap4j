package com.only4.application.validater;

import com.only4.application.queries.admin_user.ExistedAdminUserByRoleIdQry;
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
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Constraint(validatedBy = {RoleNotRef.validator.class})
public @interface RoleNotRef {

    String message() default "该角色已经分配用户，无法删除";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validator implements ConstraintValidator<RoleNotRef, Long> {

        @Override
        public boolean isValid(Long roleId, ConstraintValidatorContext constraintValidatorContext) {
            var send = Mediator.queries().send(
                    ExistedAdminUserByRoleIdQry.Request.builder()
                            .roleId(roleId)
                            .build());
            return !send.getExisted();
        }
    }
}
