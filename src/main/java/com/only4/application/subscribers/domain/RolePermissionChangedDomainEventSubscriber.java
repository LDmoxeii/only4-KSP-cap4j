package com.only4.application.subscribers.domain;

import com.only4.application.commands.identity.UpdateAdminUserRolePermissionsCmdRequest;
import com.only4.application.queries.identity.GetAdminUserByRoleIdQryRequest;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.RolePermissionChangedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Role.RolePermissionChangedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class RolePermissionChangedDomainEventSubscriber {

    @EventListener(RolePermissionChangedDomainEvent.class)
    public void on(RolePermissionChangedDomainEvent event) {
        Role role = event.getRole();
        Long roleId = role.getId();
        var send = Mediator.queries().send(new GetAdminUserByRoleIdQryRequest(roleId));
        List<AdminUser> adminUsers = send.getAdminUsers();
        List<AdminUserPermission> permissions = role.getRolePermissions().stream()
                .map(p -> new AdminUserPermission(p.getPermissionCode(), p.getPermissionRemark()))
                .collect(Collectors.toList());
        adminUsers.forEach(adminUser ->
                Mediator.commands().send(new UpdateAdminUserRolePermissionsCmdRequest(adminUser.getId(), roleId, permissions))
        );
    }

}
