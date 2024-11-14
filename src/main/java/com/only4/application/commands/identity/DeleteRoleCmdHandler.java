package com.only4.application.commands.identity;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.role.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.netcorepal.cap4j.ddd.domain.repo.Predicate;
import org.netcorepal.cap4j.ddd.domain.repo.RepositorySupervisor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
    @Validated
    public DeleteRoleCmdResponse exec(DeleteRoleCmdRequest cmd) {
        RepositorySupervisor repositories = Mediator.repositories();
        Predicate<Role> predicate = JpaPredicate.byId(Role.class, cmd.roleId);
        boolean exists = repositories.exists(predicate);
        if (!exists) {
            throw new KnownException("角色不存在, roleId=" + cmd.roleId);
        }
        repositories.remove(predicate, 1);
        Mediator.uow().save();

        return DeleteRoleCmdResponse.builder()
                .success(true)
                .build();
    }
}
