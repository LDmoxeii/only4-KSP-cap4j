package com.only4.domain.aggregates.admin_user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import java.util.Collections;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdminUserTest {

  @Test
  void updatePassword() {
    var adminUser = AdminUser.builder().build();
    Assertions.assertNull(adminUser.getPassword());
    adminUser.updatePassword("123");
    Assertions.assertEquals("123", adminUser.getPassword());
  }

  @Test
  void updateRoles() {
    AdminUserRole admin = AdminUserRole.builder()
        .roleId(1L)
        .roleName("admin")
        .build();
    AdminUserPermission permission = AdminUserPermission.builder()
        .permissionCode("test")
        .permissionRemark("test")
        .build();

    AdminUser adminUser = AdminUser.builder()
        .adminUserRoles(Collections.singletonList(admin))
        .adminUserPermissions(Collections.singletonList(permission))
        .build();


    AssignAdminUserRoleDto role =  new AssignAdminUserRoleDto(1L, "normal",
        Collections.singletonList(permission));
    adminUser.updateRoles(Collections.singletonList(role));

    assertEquals(1, adminUser.getAdminUserRoles().size());
    assertEquals(1, adminUser.getAdminUserPermissions().size());
  }
}
