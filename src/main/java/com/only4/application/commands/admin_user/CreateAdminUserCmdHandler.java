package com.only4.application.commands.admin_user;

import com.only4.application._share.utils.ValidatorUtils;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.factory.AdminUserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * CreateAminUserCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAdminUserCmdHandler implements
    Command<CreateAdminUserCmdRequest, CreateAdminUserCmdResponse> {

  @Override
  public CreateAdminUserCmdResponse exec(CreateAdminUserCmdRequest cmd) {
    ValidatorUtils.validate(cmd);

    // 创建实体
    AdminUser adminUser = Mediator.factories().create(
        AdminUserPayload.builder()
            .name(cmd.getName())
            .phone(cmd.getPhone())
            .password(cmd.getPassword())
            .rolesToBeAssigned(cmd.getRolesToBeAssigned())
            .build()
    );

    // 保存数据库
    Mediator.uow().persist(adminUser);
    Mediator.uow().save();

    // 返回结果
    return CreateAdminUserCmdResponse.builder()
        .id(adminUser.getId())
        .success(true)
        .build();
  }
}
