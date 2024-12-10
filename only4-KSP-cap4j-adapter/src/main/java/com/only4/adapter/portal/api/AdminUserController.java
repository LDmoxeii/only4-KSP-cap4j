package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import com.only4._share.exception.KnownException;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.adapter.portal.api.request.AdminUserQryRequest;
import com.only4.adapter.portal.api.request.CreateAdminUserRequest;
import com.only4.adapter.portal.api.response.AdminUserResponse;
import com.only4.adapter.portal.api.response.AdminUserRolesResponse;
import com.only4.application.commands.admin_user.CreateAdminUserCmd;
import com.only4.application.commands.admin_user.DeleteAdminUserCmd;
import com.only4.application.commands.admin_user.UpdateAdminUserPasswordCmd;
import com.only4.application.queries.admin_user.GetAdminUserByIdQry;
import com.only4.application.queries.admin_user.GetAdminUsersByConditionQry;
import com.only4.application.queries.admin_user.GetAllAdminUserQry;
import com.only4.application.queries.role.GetAllRolesQry;
import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.netcorepal.cap4j.ddd.Mediator.commands;
import static org.netcorepal.cap4j.ddd.Mediator.queries;

/**
 * @author LD_moxeii
 */
@Slf4j
@SaIgnore
@RestController
@RequestMapping("adminUser")
public class AdminUserController {

  @PostMapping("createAdminUser")
  public ResponseData<?> createAdminUser(@RequestBody CreateAdminUserRequest request) {
    var send = queries().send(
        GetAllRolesQry.Request.builder().build()
    );
    var rolesToBeAssigned = send.getRoles().stream()
        .filter(r -> request.getRoleIds().contains(r.getId()))
        .map(r -> new AssignAdminUserRoleDto(
            r.getId(),
            r.getName(),
            r.getRolePermissions().stream()
                .map(rp ->
                    AdminUserPermission.builder()
                        .permissionCode(rp.getPermissionCode())
                        .permissionRemark(rp.getPermissionRemark())
                        .build()
                ).collect(Collectors.toList()))
        )
        .collect(Collectors.toList());

    var result = commands().send(
            CreateAdminUserCmd.Request.builder()
                    .name(request.getName())
                    .phone(request.getPhone())
                    .password(request.getPassword())
                    .rolesToBeAssigned(rolesToBeAssigned)
                    .build()
    );
    return ResponseData.success(result.getId());
  }

  @GetMapping("getAllAdminUsers")
  public ResponseData<?> getAllAdminUsers() {
    var send = queries().send(
        GetAllAdminUserQry.Request.builder().build()
    );
    var result = send.getAdminUsers().stream()
        .map(AdminUserResponse::new)
        .collect(Collectors.toList());

    return ResponseData.success(result);
  }

  @PostMapping("getAdminUsersByCondition")
  public ResponseData<?> getAdminUsersByCondition(@RequestBody AdminUserQryRequest request) {
    var send = queries().send(
        GetAdminUsersByConditionQry.Request.builder()
            .name(request.getName())
            .phone(request.getPhone())
            .build()
    );
    var result = send.getAdminUsers().stream()
        .map(AdminUserResponse::new)
        .collect(Collectors.toList());
    return ResponseData.success(result);
  }

  @GetMapping("{id}")
  public ResponseData<?> getAdminUserById(@PathVariable Long id) {
    var send = queries().send(
        GetAdminUserByIdQry.Request.builder()
            .id(id)
            .build()
    );
    AdminUserResponse result = new AdminUserResponse(send.getAdminUser());
    return ResponseData.success(result);
  }

  @PutMapping("changeAdminUserPassword/{id}")
  public ResponseData<?> changeAdminUserPassword(@PathVariable Long id, String newPassword) {
    var AdminUserQry = queries().send(
        GetAdminUserByIdQry.Request.builder()
            .id(id)
            .build()
    );
    Optional.ofNullable(AdminUserQry.getAdminUser())
        .orElseThrow(() -> new KnownException("未找到用户， UserId =" + id));
    commands().send(
        UpdateAdminUserPasswordCmd.Request.builder()
            .adminUserId(id)
            .newPassword(newPassword)
            .build()
    );
    return ResponseData.success("ok");
  }

  @PutMapping("getAdminUserRoles/{id}")
  public ResponseData<?> getAdminUserRoles(@PathVariable Long id) {
    val adminUser = queries().send(
        GetAdminUserByIdQry.Request.builder()
            .id(id)
            .build()
    ).getAdminUser();
    Optional.ofNullable(adminUser)
        .orElseThrow(() -> new KnownException("未找到用户， UserId =" + id));
    var allRoles = queries().send(
        GetAllRolesQry.Request.builder().build()
    ).getRoles();
    List<AdminUserRolesResponse> result = allRoles.stream()
        .map(role -> adminUser.isInRole(role.getName())
            ? AdminUserRolesResponse.builder()
            .roleId(role.getId())
            .roleName(role.getName())
            .description(role.getDescription())
            .isAssigned(true)
            .build()
            : AdminUserRolesResponse.builder()
                .roleId(role.getId())
                .roleName(role.getName())
                .description(role.getDescription())
                .isAssigned(false)
                .build()
        ).collect(Collectors.toList());
    return ResponseData.success(result);
  }

  @DeleteMapping("{id}")
  public ResponseData<?> deleteAdminUser(@PathVariable Long id) {
    commands().send(
        DeleteAdminUserCmd.Request.builder()
            .adminUserId(id)
            .build()
    );
    return ResponseData.success("ok");
  }

}