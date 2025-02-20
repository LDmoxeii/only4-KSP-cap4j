package com.only4.application.commands.admin_user;


import com.only4.application.validater.AdminUserUniqueName;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import com.only4.domain.aggregates.admin_user.factory.AdminUserFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 创建管理员用户
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
                    AdminUserFactory.Payload.builder()
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

        @NotBlank(message = "用户名不能为空")
        @AdminUserUniqueName
        String name;

        @NotBlank(message = "手机号不能为空")
        String phone;

        @NotBlank(message = "密码不能为空")
        String password;

        @NotNull
        List<AssignAdminUserRoleDto> rolesToBeAssigned;
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
