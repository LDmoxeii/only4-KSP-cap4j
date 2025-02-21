package com.only4.application.subscribers.domain;

import com.only4.application.commands.admin_user.UpdateAdminUserRoleInfoCmd;
import com.only4.application.queries.admin_user.GetAdminUserByRoleIdQry;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.RoleInfoUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Role.UpdatedRoleInfoDomainEvent领域事件订阅
 * 角色信息已更新
 */
@Service
@RequiredArgsConstructor
public class RoleInfoUpdatedDomainEventSubscriber {

    @EventListener(RoleInfoUpdatedDomainEvent.class)
    public void on(RoleInfoUpdatedDomainEvent event) {
        Role role = event.getEntity();

        var send = Mediator.queries().send(new GetAdminUserByRoleIdQry.Request(role.getId()));
        send.getAdminUsers().forEach(adminUser ->
                Mediator.commands()
                        .send(UpdateAdminUserRoleInfoCmd.Request.builder()
                                .adminUserId(adminUser.getId())
                                .roleId(role.getId())
                                .roleName(role.getName())
                                .build())
        );
    }

}
