package com.only4.application.commands.identity;

import com.only4._share.exception.KnownException;
import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.netcorepal.cap4j.ddd.domain.repo.Predicate;
import org.springframework.stereotype.Service;

/**
 * DeleteRoleCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteRoleCmdHandler implements Command<DeleteRoleCmdRequest, DeleteRoleCmdResponse> {

  @Override
  public DeleteRoleCmdResponse exec(DeleteRoleCmdRequest cmd) {
    ValidatorUtils.validate(cmd);
    Predicate<Role> predicate = JpaPredicate.byId(Role.class, cmd.roleId);
    Role role = Mediator.repositories()
        .findOne(predicate)
        .orElseThrow(() -> new KnownException("角色不存在, roleId=" + cmd.roleId));
    Mediator.uow().remove(role);
    Mediator.uow().save();
    return DeleteRoleCmdResponse.builder()
        .success(true)
        .build();
  }
}
