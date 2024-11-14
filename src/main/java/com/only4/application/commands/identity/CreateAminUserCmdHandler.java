package com.only4.application.commands.identity;

import com.only4.adapter.domain.repositories.AdminUserRepository;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.factory.AdminUserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
public class CreateAminUserCmdHandler implements Command<CreateAminUserCmdRequest, CreateAminUserCmdResponse> {
    public final AdminUserRepository adminUserRepository;

    @Override
    @Validated
    public CreateAminUserCmdResponse exec(CreateAminUserCmdRequest cmd) {
        AdminUser adminUser = Mediator.factories().create(
                AdminUserPayload.builder()
                        .name(cmd.name)
                        .phone(cmd.phone)
                        .rolesToBeAssigned(cmd.rolesToBeAssigned)
                        .build()
        );
        adminUserRepository.save(adminUser);
        Mediator.uow().save();
        return CreateAminUserCmdResponse.builder()
                .id(adminUser.getId())
                .success(true)
                .build();
    }
}
