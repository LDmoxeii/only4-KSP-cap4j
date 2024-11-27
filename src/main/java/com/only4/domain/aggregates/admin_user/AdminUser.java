package com.only4.domain.aggregates.admin_user;

import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * 用户表
 * <p>
 * 本文件由[cap4j-ddd-codegen-maven-plugin]生成 警告：请勿手工修改该文件的字段声明，重新生成会覆盖字段声明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "AdminUser", name = "AdminUser", root = true, type = Aggregate.TYPE_ENTITY, description = "用户表")
@SuppressWarnings("ALL")
@Entity
@Table(name = "`admin_user`")
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update admin_user set is_deleted = 1 where id = ? ")
@Where(clause = "`del_flag` = 0")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AdminUser {

  // 【行为方法开始】
  public void updatePassword(String password) {
    this.password = password;
  }

  public void updateRoleInfo(Long roleId, String roleName) {
    this.getAdminUserRoles().stream()
        .filter(r -> Objects.equals(r.getRoleId(), roleId))
        .findFirst()
        .orElseThrow(() -> new KnownException("角色不存在, roleId=" + roleId))
        .updateRoleInfo(roleName);
  }

  public void updateRoles(List<AssignAdminUserRoleDto> rolesToBeAssigned) {
    Map<Long, AdminUserRole> currentRoleMap = this.getAdminUserRoles().stream()
        .collect(Collectors.toMap(r -> r.getRoleId(), r -> r));
    Map<Long, AssignAdminUserRoleDto> targetRoleMap = rolesToBeAssigned.stream()
        .collect(Collectors.toMap(AssignAdminUserRoleDto::getRoleId, r -> r));

    currentRoleMap.keySet().stream()
        .filter(roleId -> !targetRoleMap.containsKey(roleId))
        .forEach(roleId -> {
          this.adminUserRoles.remove(currentRoleMap.get(roleId));
          removeRolePermissions(roleId);
        });
    targetRoleMap.keySet().stream()
        .filter(roleId -> !currentRoleMap.containsKey(roleId))
        .forEach(roleId -> {
          AssignAdminUserRoleDto targetRole = targetRoleMap.get(roleId);
          this.adminUserRoles.add(
              AdminUserRole.builder()
                  .roleId(roleId)
                  .roleName(targetRole.getRoleName())
                  .build()
          );
          addRolePermissions(roleId, targetRole.getPermissions());
        });

  }

  private void addRolePermissions(Long roleId, List<AdminUserPermission> newPermissions) {
    newPermissions.forEach(permission -> {
      Optional<AdminUserPermission> existingPermission = this.getAdminUserPermissions().stream()
          .filter(p -> Objects.equals(p.permissionCode, permission.getPermissionCode()))
          .findFirst();
      existingPermission
          .ifPresent(p -> p.addSourceRoleId(roleId));
      if (!existingPermission.isPresent()) {
        permission.addSourceRoleId(roleId);
        this.adminUserPermissions.add(permission);
      }
    });
  }

  public void updateRolePermissions(Long roleId, List<AdminUserPermission> newPermissions) {
    removeRolePermissions(roleId);
    addRolePermissions(roleId, newPermissions);
  }

  private void removeRolePermissions(Long roleId) {
    this.getAdminUserPermissions().stream()
        .filter(p -> p.getSourceRoleIds().remove(roleId)
            && p.getSourceRoleIds().isEmpty())
        .forEach(permission -> this.adminUserPermissions.remove(permission));
  }

  public void setSpecificPermissions(List<AdminUserPermission> permissionsToBeAssigned) {
    Map<String, AdminUserPermission> currentSpecificPermissionMap = this.getAdminUserPermissions().stream()
        .collect(Collectors.toMap(AdminUserPermission::getPermissionCode, p -> p));
    Map<String, AdminUserPermission> newSpecificPermissionMap = permissionsToBeAssigned.stream()
        .collect(Collectors.toMap(AdminUserPermission::getPermissionCode, p -> p));
    currentSpecificPermissionMap.keySet().stream()
        .filter(permissionCode -> !newSpecificPermissionMap.containsKey(permissionCode))
        .forEach(permissionCode -> this.adminUserPermissions.remove(
            currentSpecificPermissionMap.get(permissionCode)));

    newSpecificPermissionMap.keySet().stream()
        .filter(permissionCode -> !currentSpecificPermissionMap.containsKey(permissionCode))
        .forEach(permissionCode -> {
          if (this.getAdminUserPermissions().stream()
              .anyMatch(p -> Objects.equals(p.getPermissionCode(), permissionCode))) {
            throw new KnownException("权限重复！");
          }
          this.adminUserPermissions.add(newSpecificPermissionMap.get(permissionCode));
        });
  }

  public void delete() {
    if (delFlag) {
      throw new KnownException("用户已经被删除！");
    }
    this.delFlag = true;
  }

  public boolean isInRole(String roleName) {
    return this.getAdminUserRoles().stream().anyMatch(r -> Objects.equals(r.roleName, roleName));
  }

  public void loginSuccessful(String refreshToken, LocalDateTime loginExpiryDate) {
    this.refreshToken = refreshToken;
    this.loginExpiryDate = loginExpiryDate;
  }

  public void updateRefreshToken(String token) {
    this.refreshToken = token;
  }

  // 【行为方法结束】

    // 【字段映射开始】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`admin_user_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.admin_user.AdminUserRole> adminUserRoles;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "`admin_user_id`", nullable = false)
    private java.util.List<com.only4.domain.aggregates.admin_user.AdminUserPermission> adminUserPermissions;

    /**
     * ID
     * bigint
     */
    @Id
    @GeneratedValue(generator = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator", strategy = "org.netcorepal.cap4j.ddd.domain.distributed.SnowflakeIdentifierGenerator")
    @Column(name = "`id`")
    Long id;

    /**
     * 用户名
     * varchar(255)
     */
    @Column(name = "`name`")
    String name;

    /**
     * 手机号
     * varchar(255)
     */
    @Column(name = "`phone`")
    String phone;

    /**
     * 密码
     * varchar(255)
     */
    @Column(name = "`password`")
    String password;

    /**
     * 刷新令牌
     * varchar(255)
     */
    @Column(name = "`refresh_token`")
    String refreshToken;

    /**
     * 过期时间
     * timestamp
     */
    @Column(name = "`login_expiry_date`", insertable = true, updatable = false)
    java.time.LocalDateTime loginExpiryDate;

    /**
     * 创建时间
     * timestamp
     */
    @Column(name = "`created_at`")
    java.time.LocalDateTime createdAt;

    /**
     * 逻辑删除
     * tinyint(1)
     */
    @Column(name = "`del_flag`")
    Boolean delFlag;

    // 【字段映射结束】本段落由[cap4j-ddd-codegen-maven-plugin]维护，请不要手工改动
}


