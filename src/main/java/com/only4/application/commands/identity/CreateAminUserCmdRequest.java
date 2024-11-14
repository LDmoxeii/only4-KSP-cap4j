package com.only4.application.commands.identity;

import com.only4.application.queries.identity.ExistedAdminUserByNameQryRequest;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.*;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * CreateAminUserCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAminUserCmdRequest implements RequestParam<CreateAminUserCmdResponse> {

    @Name
    @NotNull
    String name;

    @NotNull
    String phone;

    @NotNull
    String password;

    List<AssignAdminUserRoleDto> rolesToBeAssigned;

    @Component
    public static class NameValidator implements ConstraintValidator<Name, String> {
        @Override
        public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
            var response = Mediator.queries().send(new ExistedAdminUserByNameQryRequest(name));
            return !response.getExisted();
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Constraint(validatedBy = {NameValidator.class})
    private @interface Name {
        String message() default "该用户已存在";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
}
