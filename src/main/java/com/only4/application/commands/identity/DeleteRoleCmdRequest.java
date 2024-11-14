package com.only4.application.commands.identity;

import com.only4.application.queries.identity.ExistedAdminUserByRoleIdQryRequest;
import lombok.*;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * DeleteRoleCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRoleCmdRequest implements RequestParam<DeleteRoleCmdResponse> {
    Long roleId;

    @Component
    public static class RoleNameValidator implements ConstraintValidator<RoleId, Long> {

        @Override
        public boolean isValid(Long roleId, ConstraintValidatorContext constraintValidatorContext) {
            var send = Mediator.queries().send(new ExistedAdminUserByRoleIdQryRequest(roleId));
            return !send.getExisted();
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Constraint(validatedBy = {RoleNameValidator.class})
    private @interface RoleId {
        String message() default "该角色已经分配用户，无法删除";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }

}
