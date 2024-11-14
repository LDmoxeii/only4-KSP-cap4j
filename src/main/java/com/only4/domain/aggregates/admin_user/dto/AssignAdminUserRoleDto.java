package com.only4.domain.aggregates.admin_user.dto;

import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class AssignAdminUserRoleDto {
    private final Long roleId;
    private final String roleName;
    private final List<AdminUserPermission> permissions;
}
