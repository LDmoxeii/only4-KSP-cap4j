package com.only4.adapter.portal.api.response;

import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.admin_user.AdminUserRole;
import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class AdminUserResponse {
  Long id;
  String name;
  String phone;
  List<AdminUserRole> roles;
  List<AdminUserPermission> permissions;

  public AdminUserResponse(AdminUser adminUser) {
    this.id = adminUser.getId();
    this.name = adminUser.getName();
    this.phone = adminUser.getPhone();
    this.roles = adminUser.getAdminUserRoles();
    this.permissions = adminUser.getAdminUserPermissions();
  }
}
