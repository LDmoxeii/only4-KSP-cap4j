package com.only4.application.commands.admin_user;


import com.only4._share.exception.KnownException;
import com.only4.application.validater.RoleExists;
import com.only4.domain.aggregates.admin_user.AdminUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 更新用户角色信息
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
public class UpdateAdminUserRoleInfoCmd {

    /**
     * UpdateAdminUserRoleInfoCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            AdminUser adminUser = Mediator.repositories()
                    .findOne(JpaPredicate.byId(AdminUser.class, cmd.getAdminUserId()))
                    .orElseThrow(() -> new KnownException("用户不存在, adminUserId=" + cmd.getAdminUserId()));

            adminUser.updateRoleInfo(cmd.getRoleId(), cmd.getRoleName());
            Mediator.uow().persist(adminUser);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateAdminUserRoleInfoCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @Positive
        Long adminUserId;

        @Positive
        @RoleExists
        Long roleId;

        @NotBlank(message = "角色名称不能为空")
        String roleName;
    }

    /**
     * UpdateAdminUserRoleInfoCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
