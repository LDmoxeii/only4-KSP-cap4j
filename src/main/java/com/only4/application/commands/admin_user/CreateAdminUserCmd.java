package com.only4.application.commands.admin_user;


import com.only4.application.queries.admin_user.ExistedAdminUserByNameQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import com.only4.domain.aggregates.admin_user.factory.AdminUserPayload;
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
public class CreateAdminUserCmd {

    /**
     * CreateAdminUserCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            AdminUser adminUser = Mediator.factories().create(
                    AdminUserPayload.builder()
                            .name(cmd.getName())
                            .phone(cmd.getPhone())
                            .password(cmd.getPassword())
                            .rolesToBeAssigned(cmd.getRolesToBeAssigned())
                            .build()
            );

            // 保存数据库
            Mediator.uow().persist(adminUser);
            Mediator.uow().save();

            // 返回结果
            return Response.builder()
                    .id(adminUser.getId())
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateAdminUserCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @Name
        @NotEmpty
        String name;

        @NotEmpty
        String phone;

        @NotEmpty
        String password;

        List<AssignAdminUserRoleDto> rolesToBeAssigned;

        @Retention(RetentionPolicy.RUNTIME)
        @Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
                ElementType.PARAMETER})
        @Constraint(validatedBy = {NameValidator.class})
        private @interface Name {

            String message() default "该用户已存在";

            Class<?>[] groups() default {};

            Class<? extends Payload>[] payload() default {};
        }

        public static class NameValidator implements ConstraintValidator<Name, String> {

            @Override
            public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
                var response = Mediator.queries().send(
                        ExistedAdminUserByNameQry.Request.builder()
                                .name(name)
                                .build()
                );
                return !response.getExisted();
            }
        }
    }

    /**
     * CreateAdminUserCmd命令响应
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
