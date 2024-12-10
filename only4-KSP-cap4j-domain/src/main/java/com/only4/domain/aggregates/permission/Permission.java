package com.only4.domain.aggregates.permission;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
@RequiredArgsConstructor
public class Permission {
    private final String code;
    private final String groupName;
    private final String remark;

    private static final List<Permission> ALL = Arrays.asList(
            // AdminUserManagement
            new Permission(PermissionDefinitions.ADMIN_USER_CREATE, PermissionGroup.SYSTEM_ACCESS, "创建管理员用户"),
            new Permission(PermissionDefinitions.ADMIN_USER_EDIT, PermissionGroup.SYSTEM_ACCESS, "更新管理员用户信息"),
            new Permission(PermissionDefinitions.ADMIN_USER_DELETE, PermissionGroup.SYSTEM_ACCESS, "删除管理员用户"),
            new Permission(PermissionDefinitions.ADMIN_USER_VIEW, PermissionGroup.SYSTEM_ACCESS, "查询管理员用户"),
            new Permission(PermissionDefinitions.ADMIN_USER_UPDATE_ROLES, PermissionGroup.SYSTEM_ACCESS, "更新管理员用户角色"),
            new Permission(PermissionDefinitions.ADMIN_USER_UPDATE_PASSWORD, PermissionGroup.SYSTEM_ACCESS, "更新管理员用户密码"),

            // RoleManagement
            new Permission(PermissionDefinitions.ROLE_CREATE, PermissionGroup.SYSTEM_ACCESS, "创建角色"),
            new Permission(PermissionDefinitions.ROLE_EDIT, PermissionGroup.SYSTEM_ACCESS, "更新角色信息"),
            new Permission(PermissionDefinitions.ROLE_UPDATE_PERMISSIONS, PermissionGroup.SYSTEM_ACCESS, "更新角色权限"),
            new Permission(PermissionDefinitions.ROLE_VIEW, PermissionGroup.SYSTEM_ACCESS, "查询角色"),
            new Permission(PermissionDefinitions.ROLE_DELETE, PermissionGroup.SYSTEM_ACCESS, "删除角色")
    );

    public static List<Permission> getAllPermissions() {
        return Collections.unmodifiableList(ALL);
    }
}
