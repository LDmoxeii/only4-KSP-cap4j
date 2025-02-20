package com.only4.application.commands.role;


import com.only4.application.validater.RoleUniqueName;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import com.only4.domain.aggregates.role.factory.RoleFactory;
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
 * 创建角色
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

            role.create();
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

        @NotBlank(message = "角色名不能为空")
        @RoleUniqueName
        String name;

        @NotBlank(message = "角色描述不能为空")
        String description;

        @NotNull
        List<RolePermission> permissions;
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
