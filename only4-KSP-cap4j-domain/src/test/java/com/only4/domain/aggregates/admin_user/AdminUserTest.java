package com.only4.domain.aggregates.admin_user;

import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@Slf4j
@ExtendWith(MockitoExtension.class)
class AdminUserTest {

  @Spy
  private AdminUser adminUser;

  @Mock
  private AdminUserRole adminUserRole;

  @Mock
  private AdminUserPermission adminUserPermission;

  @Nested
  class UpdatePasswordTests {
    @Test
    void testUpdatePassword() {
      String newPassword = "newPassword123";

      adminUser.updatePassword(newPassword);

      assertEquals(newPassword, adminUser.getPassword());
    }
  }

  @Nested
  class UpdateRoleInfoTests {
    @Test
    void testUpdateRoleInfo() {
      Long roleId = 1L;
      String newRoleName = "New Role Name";

      List<AdminUserRole> roles = new ArrayList<>();
      roles.add(AdminUserRole.builder().roleId(roleId).roleName("Old Role Name").build());
      doReturn(roles).when(adminUser).getAdminUserRoles();

      adminUser.updateRoleInfo(roleId, newRoleName);

      assertEquals(newRoleName, roles.get(0).getRoleName());
    }

    @Test
    void testUpdateRoleInfoRoleNotFound() {
      Long roleId = 1L;
      String newRoleName = "New Role Name";

      doReturn(new ArrayList<>()).when(adminUser).getAdminUserRoles();

      KnownException exception = assertThrows(KnownException.class,
              () -> adminUser.updateRoleInfo(roleId, newRoleName));
      assertEquals("角色不存在, roleId=" + roleId, exception.getMessage());
    }
  }

  @Nested
  class UpdateRolesTests {
    @Test
    void testUpdateRoles() {
      Long roleId = 1L;
      String roleName = "Role Name";
      List<AssignAdminUserRoleDto> rolesToBeAssigned = new ArrayList<>();
      rolesToBeAssigned.add(new AssignAdminUserRoleDto(roleId, roleName, new ArrayList<>()));

      List<AdminUserRole> currentRoles = new ArrayList<>();
      currentRoles.add(AdminUserRole.builder().roleId(2L).roleName("Old Role").build());
      doReturn(currentRoles).when(adminUser).getAdminUserRoles();
      doNothing().when(adminUser).removeRolePermissions(2L);
      doNothing().when(adminUser).addRolePermissions(roleId, rolesToBeAssigned.get(0).getPermissions());

      adminUser.updateRoles(rolesToBeAssigned);

      assertEquals(1, adminUser.getAdminUserRoles().size());
      assertEquals(roleId, adminUser.getAdminUserRoles().get(0).getRoleId());
      assertEquals(roleName, adminUser.getAdminUserRoles().get(0).getRoleName());
    }
  }

  @Nested
  class DeleteTests {
    @Test
    void testDelete() {
      doReturn("NonDefaultUser").when(adminUser).getName();

      assertDoesNotThrow(() -> adminUser.delete());
    }

    @Test
    void testDeleteDefaultUser() {
      doReturn(AppDefaultCredentials.NAME).when(adminUser).getName();

      KnownException exception = assertThrows(KnownException.class,
              () -> adminUser.delete());
      assertEquals("默认账号不允许删除", exception.getMessage());
    }
  }

  @Nested
  class LoginTests {
    @Test
    void testLoginSuccessful() {
      String refreshToken = "refreshToken123";
      LocalDateTime loginExpiryDate = LocalDateTime.now();

      adminUser.loginSuccessful(refreshToken, loginExpiryDate);

      assertEquals(refreshToken, adminUser.getRefreshToken());
      assertEquals(loginExpiryDate, adminUser.getLoginExpiryDate());
    }

    @Test
    void testUpdateRefreshToken() {
      String newRefreshToken = "newRefreshToken123";

      adminUser.updateRefreshToken(newRefreshToken);

      assertEquals(newRefreshToken, adminUser.getRefreshToken());
    }
  }

  @Nested
  class RoleAndPermissionTests {
    @Test
    void testIsInRole() {
      String roleName = "Admin";
      List<AdminUserRole> roles = new ArrayList<>();
      roles.add(AdminUserRole.builder().roleName(roleName).build());
      doReturn(roles).when(adminUser).getAdminUserRoles();

      assertTrue(adminUser.isInRole(roleName));
    }

    @Test
    void testSetSpecificPermissions() {
      List<AdminUserPermission> permissions = new ArrayList<>();
      permissions.add(AdminUserPermission.builder().permissionCode("PERMISSION_1").build());
      doReturn(new ArrayList<AdminUserPermission>()).when(adminUser).getAdminUserPermissions();

      adminUser.setSpecificPermissions(permissions);

      assertEquals(1, adminUser.getAdminUserPermissions().size());
      assertEquals("PERMISSION_1", adminUser.getAdminUserPermissions().get(0).getPermissionCode());
    }
  }
}
