package com.only4.application.commands.identity;

import com.only4.application.queries.identity.GetRoleByNameQryRequest;
import com.only4.domain.aggregates.role.Role;
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
import java.util.Objects;

/**
 * UpdateRoleInfoCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleInfoCmdRequest implements RequestParam<UpdateRoleInfoCmdResponse> {

    @NotNull
    public Long roleId;

    @NotNull
    public String name;

    public String description;

    @RoleNameAndId
    private String IdAndName = roleId + "," + name;

    public UpdateRoleInfoCmdRequest(Long roleId, String name, String description) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }

    @Component
    public static class RoleNameAndIdValidator implements ConstraintValidator<RoleNameAndId, String> {

        @Override
        public boolean isValid(String IdAndName, ConstraintValidatorContext constraintValidatorContext) {
            String[] split = IdAndName.split(",");
            var send = Mediator.queries().send(new GetRoleByNameQryRequest(split[0]));
            Role role = send.getRole();
            return Objects.isNull(role) || role.getId() == Long.parseLong(split[1]);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = {RoleNameAndIdValidator.class})
    @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    private @interface RoleNameAndId {
        String message() default "角色名称和角色ID不匹配";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
