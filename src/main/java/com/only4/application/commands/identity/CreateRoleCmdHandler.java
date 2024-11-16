package com.only4.application.commands.identity;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.factory.RolePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * CreateRoleCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CreateRoleCmdHandler implements Command<CreateRoleCmdRequest, CreateRoleCmdResponse> {

  @Override
  public CreateRoleCmdResponse exec(CreateRoleCmdRequest cmd) {
    ValidatorUtils.validate(cmd);
    Role role = Mediator.factories().create(
        RolePayload.builder()
            .name(cmd.name)
            .description(cmd.description)
            .permissions(cmd.permissions)
            .build()
    );
    Mediator.uow().persist(role);
    Mediator.uow().save();
    return CreateRoleCmdResponse.builder()
        .id(role.getId())
        .success(true)
        .build();
  }
}
