package com.only4.application.commands.admin_user;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * UpdateAdminUserRolePermissionsCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateAdminUserRolePermissionsCmdHandler implements
    Command<UpdateAdminUserRolePermissionsCmdRequest, UpdateAdminUserRolePermissionsCmdResponse> {

  @Override
  public UpdateAdminUserRolePermissionsCmdResponse exec(
      UpdateAdminUserRolePermissionsCmdRequest cmd) {
    AdminUser adminUser = Mediator.repositories()
        .findOne(JpaPredicate.byId(AdminUser.class, cmd.getAdminUserId()))
        .orElseThrow(() -> new KnownException("用户不存在, adminUserId=" + cmd.getAdminUserId()));
    adminUser.updateRolePermissions(cmd.getRoleId(), cmd.getPermissions());
    Mediator.uow().persist(adminUser);
    Mediator.uow().save();
    return UpdateAdminUserRolePermissionsCmdResponse.builder()
        .success(true)
        .build();
  }
}
