package com.only4.domain.aggregates.admin_user.factory;

import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.admin_user.AdminUserRole;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * AdminUser聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "AdminUser", name = "AdminUserFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class AdminUserFactory implements AggregateFactory<AdminUserFactory.Payload, AdminUser> {

    private List<AdminUserRole> adminUserRoles;
    private List<AdminUserPermission> adminUserPermissions;

    @Override
    public AdminUser create(Payload payload) {
        resolveParameter(payload.rolesToBeAssigned);
        return AdminUser.builder()
                .adminUserRoles(adminUserRoles)
                .adminUserPermissions(adminUserPermissions)
                .name(payload.name)
                .phone(payload.phone)
                .password(payload.password)
                .refreshToken("")
                .loginExpiryDate(LocalDateTime.MIN)
                .createdAt(LocalDateTime.now())
                .delFlag(false)
                .build();
    }

    private void resolveParameter(List<AssignAdminUserRoleDto> rolesToBeAssigned) {
        this.adminUserRoles = new ArrayList<>();
        this.adminUserPermissions = new ArrayList<>();
        for (AssignAdminUserRoleDto roleDto : rolesToBeAssigned) {
            this.adminUserRoles.add(
                    AdminUserRole.builder()
                            .roleId(roleDto.getRoleId())
                            .roleName(roleDto.getRoleName())
                            .build());
            for (AdminUserPermission permission : roleDto.getPermissions()) {
                permission.getSourceRoleIds().add(roleDto.getRoleId());
                this.adminUserPermissions.add(permission);
            }
        }
    }

    /**
     * AdminUser工厂负载
     */
    @Aggregate(aggregate = "AdminUser", name = "AdminUserPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<AdminUser> {
        String name;
        String phone;
        String password;
        List<AssignAdminUserRoleDto> rolesToBeAssigned;

    }
}
