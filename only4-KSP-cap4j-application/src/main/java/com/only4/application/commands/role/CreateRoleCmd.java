package com.only4.application.commands.role;


import com.only4.application.queries.role.ExistedRoleByNameQry;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import com.only4.domain.aggregates.role.factory.RoleFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class CreateRoleCmd {

    /**
     * CreateRoleCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Role role = Mediator.factories().create(
                    RoleFactory.Payload.builder()
                            .name(cmd.name)
                            .description(cmd.description)
                            .permissions(cmd.permissions)
                            .build()
            );
            Mediator.uow().persist(role);
            Mediator.uow().save();
            return Response.builder()
                    .id(role.getId())
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateRoleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @NotEmpty
        @RoleName
        String name;

        @NotEmpty
        String description;

        List<RolePermission> permissions;

        @Retention(RetentionPolicy.RUNTIME)
        @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
                ElementType.PARAMETER})
        @Constraint(validatedBy = {RoleNameValidator.class})
        private @interface RoleName {

            String message() default "角色名重复";

            Class<?>[] groups() default {};

            Class<? extends Payload>[] payload() default {};
        }

        public static class RoleNameValidator implements
                ConstraintValidator<RoleName, String> {

            @Override
            public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
                var send = Mediator.queries().send(
                        ExistedRoleByNameQry.Request.builder()
                                .name(name)
                                .build()
                );
                return !send.getExisted();
            }
        }
    }

    /**
     * CreateRoleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        Long id;
        boolean success;
    }
}
