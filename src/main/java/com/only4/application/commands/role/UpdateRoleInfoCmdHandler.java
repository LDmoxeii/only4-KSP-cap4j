package com.only4.application.commands.role;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * UpdateRoleInfoCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateRoleInfoCmdHandler implements
    Command<UpdateRoleInfoCmdRequest, UpdateRoleInfoCmdResponse> {

  @Override
  public UpdateRoleInfoCmdResponse exec(UpdateRoleInfoCmdRequest cmd) {
    Role role = Mediator.repositories()
        .findOne(JpaPredicate.byId(Role.class, cmd.getRoleId()))
        .orElseThrow(() -> new KnownException("角色不存在, roleId=" + cmd.getRoleId()));
    role.updateRoleInfo(cmd.getName(), cmd.getDescription());
    Mediator.uow().persist(role);
    Mediator.uow().save();
    return UpdateRoleInfoCmdResponse.builder()
        .success(true)
        .build();
  }
}
