package com.only4.application.commands.admin_user;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AppDefaultCredentials;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * DeleteAdminUserCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteAdminUserCmdHandler implements
    Command<DeleteAdminUserCmdRequest, DeleteAdminUserCmdResponse> {

  @Override
  public DeleteAdminUserCmdResponse exec(DeleteAdminUserCmdRequest cmd) {
    AdminUser adminUser = Mediator.repositories()
        .findOne(JpaPredicate.byId(AdminUser.class, cmd.adminUserId))
        .orElseThrow(() -> new KnownException("用户不存在, adminUserId=" + cmd.adminUserId));
    if (Objects.equals(adminUser.getName(), AppDefaultCredentials.NAME)) {
      throw new KnownException("默认账号不允许删除");
    }
    adminUser.delete();
    Mediator.uow().remove(adminUser);
    Mediator.uow().save();
    return DeleteAdminUserCmdResponse.builder()
        .success(true)
        .build();
  }
}
