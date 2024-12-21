package com.only4.application.subscribers.domain;

import com.only4.application.commands.admin_user.UpdateAdminUserRoleInfoCmd;
import com.only4.application.queries.admin_user.GetAdminUserByRoleIdQry;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.UpdatedRoleInfoDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Role.UpdatedRoleInfoDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UpdatedRoleInfoDomainEventSubscriber {

    @EventListener(UpdatedRoleInfoDomainEvent.class)
    public void on(UpdatedRoleInfoDomainEvent event) {
        Role role = event.getRole();
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
