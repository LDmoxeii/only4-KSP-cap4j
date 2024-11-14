package com.only4.application.subscribers.domain;

import com.only4.application.commands.identity.UpdateAdminUserRoleInfoCmdRequest;
import com.only4.application.queries.identity.GetAdminUserByRoleIdQryRequest;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.RoleInfoChangedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Role.RoleInfoChangedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class RoleInfoChangedDomainEventSubscriber {

    @EventListener(RoleInfoChangedDomainEvent.class)
    public void on(RoleInfoChangedDomainEvent event) {
        Role role = event.getRole();
        var send = Mediator.queries().send(new GetAdminUserByRoleIdQryRequest(role.getId()));
        send.getAdminUsers().forEach(adminUser -> {
            Mediator.commands().send(new UpdateAdminUserRoleInfoCmdRequest(adminUser.getId(), role.getId(), role.getName()));
        });
    }

}
