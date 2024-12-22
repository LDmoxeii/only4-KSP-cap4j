package com.only4.application.subscribers.domain;

import com.only4.application.commands.admin_user.UpdateAdminUserRolePermissionsCmd;
import com.only4.application.queries.admin_user.GetAdminUserByRoleIdQry;
import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.events.UpdatedRolePermissionsDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Role.UpdatedRolePermissionsDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UpdatedRolePermissionsDomainEventSubscriber {

    @EventListener(UpdatedRolePermissionsDomainEvent.class)
    public void on(UpdatedRolePermissionsDomainEvent event) {
        Role role = event.getRole();
        Long roleId = role.getId();
        var send = Mediator.queries().send(
                GetAdminUserByRoleIdQry.Request.builder()
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
                Mediator.commands().send(
                        UpdateAdminUserRolePermissionsCmd.Request.builder()
                                .adminUserId(adminUser.getId())
                                .roleId(roleId)
                                .permissions(permissions)
                                .build())
        );
    }

}