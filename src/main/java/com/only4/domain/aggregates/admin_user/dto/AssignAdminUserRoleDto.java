package com.only4.domain.aggregates.admin_user.dto;

import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignAdminUserRoleDto {
    private Long roleId;
    private String roleName;
    private List<AdminUserPermission> permissions;
}
