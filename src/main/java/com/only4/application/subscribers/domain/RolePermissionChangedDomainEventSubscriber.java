package com.only4.application.subscribers.domain;

import com.only4.application.commands.admin_user.UpdateAdminUserRolePermissionsCmdRequest;
import com.only4.application.queries.admin_user.GetAdminUserByRoleIdQryRequest;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.RolePermissionChangedDomainEvent;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Role.RolePermissionChangedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RolePermissionChangedDomainEventSubscriber {

    @EventListener(RolePermissionChangedDomainEvent.class)
    public void on(RolePermissionChangedDomainEvent event) {
        Role role = event.getRole();
        Long roleId = role.getId();
        var send = Mediator.queries().send(
                GetAdminUserByRoleIdQryRequest.builder()
                        .id(roleId)
                        .build());
        List<AdminUser> adminUsers = send.getAdminUsers();
        List<AdminUserPermission> permissions = role.getRolePermissions().stream()
                .map(p -> AdminUserPermission.builder()
                    .permissionCode(p.getPermissionCode())
                    .permissionRemark(p.getPermissionRemark())
                    .build()
                )
                .collect(Collectors.toList());
        adminUsers.forEach(adminUser ->
                Mediator.commands().send(UpdateAdminUserRolePermissionsCmdRequest.builder()
                        .adminUserId(adminUser.getId())
                        .roleId(roleId)
                        .permissions(permissions)
                        .build())
        );
    }

}
