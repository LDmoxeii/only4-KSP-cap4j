package com.only4.application.commands.role;


import com.only4.application.validater.RoleNotRef;
import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.role.Role;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 删除角色
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

            role.delete();
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

        @Positive
        @RoleNotRef
        Long roleId;

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
