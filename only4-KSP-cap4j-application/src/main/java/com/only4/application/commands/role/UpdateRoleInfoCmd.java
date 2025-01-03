package com.only4.application.commands.role;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.role.Role;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class UpdateRoleInfoCmd {

    /**
     * UpdateRoleInfoCmd命令请求实现
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
            role.updateRoleInfo(cmd.getName(), cmd.getDescription());
            Mediator.uow().persist(role);
            Mediator.uow().save();
            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateRoleInfoCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        public Long roleId;

        @NotEmpty
        public String name;

        public String description;
    }

    /**
     * UpdateRoleInfoCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
