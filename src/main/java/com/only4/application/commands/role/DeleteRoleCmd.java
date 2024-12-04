package com.only4.application.commands.role;


import com.only4._share.exception.KnownException;
import com.only4.application.queries.admin_user.ExistedAdminUserByRoleIdQryRequest;
import com.only4.domain.aggregates.role.Role;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class DeleteRoleCmd {

    /**
     * DeleteRoleCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Role role = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Role.class, cmd.getRoleId()))
                    .orElseThrow(() -> new KnownException("角色不存在, roleId=" + cmd.getRoleId()));
            Mediator.uow().remove(role);
            Mediator.uow().save();
            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * DeleteRoleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @RoleId
        Long roleId;

        @Retention(RetentionPolicy.RUNTIME)
        @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
                ElementType.PARAMETER})
        @Constraint(validatedBy = {RoleNameValidator.class})
        private @interface RoleId {

            String message() default "该角色已经分配用户，无法删除";

            Class<?>[] groups() default {};

            Class<? extends Payload>[] payload() default {};
        }

        public static class RoleNameValidator implements ConstraintValidator<RoleId, Long> {

            @Override
            public boolean isValid(Long roleId, ConstraintValidatorContext constraintValidatorContext) {
                var send = Mediator.queries().send(
                        ExistedAdminUserByRoleIdQryRequest.builder()
                                .roleId(roleId)
                                .build());
                return !send.getExisted();
            }
        }
    }

    /**
     * DeleteRoleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
