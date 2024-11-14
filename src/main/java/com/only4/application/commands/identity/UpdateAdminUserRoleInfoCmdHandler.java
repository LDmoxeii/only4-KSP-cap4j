package com.only4.application.commands.identity;

import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * UpdateAdminUserRoleInfoCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateAdminUserRoleInfoCmdHandler implements Command<UpdateAdminUserRoleInfoCmdRequest, UpdateAdminUserRoleInfoCmdResponse> {

    @Override
    public UpdateAdminUserRoleInfoCmdResponse exec(UpdateAdminUserRoleInfoCmdRequest cmd) {
        Mediator.repositories().findOne(JpaPredicate.byId(AdminUser.class, cmd.adminUserId))
                .orElseThrow(() -> new RuntimeException("用户不存在, adminUserId=" + cmd.adminUserId))
                .updateRoleInfo(cmd.roleId, cmd.roleName);
        Mediator.uow().save();

        return UpdateAdminUserRoleInfoCmdResponse.builder()
                .success(true)
                .build();
    }
}
