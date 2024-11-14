package com.only4.domain.aggregates.admin_user.factory;

import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.admin_user.AdminUserRole;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * AdminUser聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "admin_user", name = "AdminUserFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class AdminUserFactory implements AggregateFactory<AdminUserPayload, AdminUser> {
    private List<AdminUserPermission> adminUserPermissions;
    private List<AdminUserRole>  adminUserRoles;

    @Override
    public AdminUser create(AdminUserPayload payload) {
        resolveParameter(payload.rolesToBeAssigned);
        return AdminUser.builder()
                .createdAt(LocalDateTime.now())
                .name(payload.name)
                .phone(payload.phone)
                .password(payload.password)
                .adminUserRoles(adminUserRoles)
                .adminUserPermissions(adminUserPermissions)
                .build();
    }
    private void resolveParameter(List<AssignAdminUserRoleDto> rolesToBeAssigned) {
        for (AssignAdminUserRoleDto roleDto : rolesToBeAssigned) {
            this.adminUserRoles.add(new AdminUserRole(roleDto.getRoleId(), roleDto.getRoleName()));
            for (AdminUserPermission permission : roleDto.getPermissions()) {
                permission.getSourceRoleIds().add(roleDto.getRoleId());
                this.adminUserPermissions.add(permission);
            }
        }
    }


}
