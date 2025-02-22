package com.only4.application.subscribers.domain;

import com.only4.application.commands.admin_user.UpdateAdminUserRolePermissionsCmd;
import com.only4.application.queries.admin_user.GetAdminUserByRoleIdQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.RolePermissionsUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Role.UpdatedRolePermissionsDomainEvent领域事件订阅
 * 角色权限集已更新
 */
@Service
@RequiredArgsConstructor
public class RolePermissionsUpdatedDomainEventSubscriber {

    @EventListener(RolePermissionsUpdatedDomainEvent.class)
    public void on(RolePermissionsUpdatedDomainEvent event) {
        Role role = event.getRole();
        Long roleId = role.getId();
        var send = Mediator.queries().send(
                GetAdminUserByRoleIdQry.Request.builder()
                        .adminUserId(roleId)
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
                Mediator.commands().send(
                        UpdateAdminUserRolePermissionsCmd.Request.builder()
                                .adminUserId(adminUser.getId())
                                .roleId(roleId)
                                .permissions(permissions)
                                .build())
        );
    }

}
