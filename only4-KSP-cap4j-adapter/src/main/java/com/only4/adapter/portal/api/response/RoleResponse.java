package com.only4.adapter.portal.api.response;

import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class RoleResponse {
    Long id;
    String name;
    String description;
    List<RolePermission> permissions;
    public RoleResponse(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.description = role.getDescription();
        this.permissions = role.getRolePermissions();
    }
}
