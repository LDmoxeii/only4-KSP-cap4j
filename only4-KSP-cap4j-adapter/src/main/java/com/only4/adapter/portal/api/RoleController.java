package com.only4.adapter.portal.api;

import cn.dev33.satoken.annotation.SaIgnore;
import com.only4._share.exception.KnownException;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.adapter.portal.api.request.CreateRoleRequest;
import com.only4.adapter.portal.api.request.UpdateRoleInfoRequest;
import com.only4.adapter.portal.api.response.RolePermissionResponse;
import com.only4.adapter.portal.api.response.RoleResponse;
import com.only4.application.commands.role.CreateRoleCmd;
import com.only4.application.commands.role.DeleteRoleCmd;
import com.only4.application.commands.role.UpdateRoleInfoCmd;
import com.only4.application.commands.role.UpdateRolePermissionsCmd;
import com.only4.application.queries.role.GetAllRolesQry;
import com.only4.application.queries.role.GetRolesByConditionQry;
import com.only4.application.queries.role.GetRolesByIdQry;
import com.only4.domain.aggregates.permission.Permission;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.netcorepal.cap4j.ddd.Mediator.commands;
import static org.netcorepal.cap4j.ddd.Mediator.queries;

/**
 * @author LD_moxeii
 */
@RestController
@SaIgnore
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

  @PostMapping("createRole")
  public ResponseData<?> createRole(@RequestBody CreateRoleRequest request) {
    List<Permission> allPermissions = Permission.getAllPermissions();
    List<RolePermission> permissionsToBeAssigned = allPermissions.stream()
        .filter(p -> request.getPermissionCodes().contains(p.getCode()))
        .map(p ->
            RolePermission.builder()
                .permissionCode(p.getCode())
                .permissionRemark(p.getRemark())
                .build()
        )
        .collect(Collectors.toList());
    var send = commands().send(
        CreateRoleCmd.Request.builder()
            .name(request.getName())
            .description(request.getDescription())
            .permissions(permissionsToBeAssigned)
            .build()
    );
    return ResponseData.success(send);
  }

  @GetMapping("getAllRoles")
  public ResponseData<?> getAllRoles() {
    var send = queries().send(GetAllRolesQry.Request.builder().build());
    List<RoleResponse> result = send.getRoles().stream()
        .map(RoleResponse::new)
        .collect(Collectors.toList());
    return ResponseData.success(result);
  }

  @PostMapping("getRolesByCondition")
  public ResponseData<?> getRolesByCondition(@RequestBody CreateRoleRequest request) {
    var send = queries().send(
        GetRolesByConditionQry.Request.builder()
            .name(request.getName())
            .description(request.getDescription())
            .build()
    );
    List<RoleResponse> result = send.getRoles().stream()
        .map(RoleResponse::new)
        .collect(Collectors.toList());
    return ResponseData.success(result);
  }

  @GetMapping("{id}")
  public ResponseData<?> getRoleById(@PathVariable("id") Long id) {
    var send = queries().send(
        GetRolesByIdQry.Request.builder()
            .id(id)
            .build()
    );
    Role role = Optional.ofNullable(send.getRole())
        .orElseThrow(() -> new KnownException("未找到角色， RoleId =" + id));
    RoleResponse result = new RoleResponse(role);
    return ResponseData.success(result);
  }

  @GetMapping("getRolePermissions/{id}")
  public ResponseData<?> getRolePermissions(@PathVariable Long id) {
    var send = queries().send(GetRolesByIdQry.Request.builder()
        .id(id)
        .build());
    Role role = Optional.ofNullable(send.getRole())
        .orElseThrow(() -> new KnownException("未找到角色， RoleId =" + id));
    List<Permission> allPermissions = Permission.getAllPermissions();
    List<String> rolePermissionCodes = role.getRolePermissions().stream()
        .map(RolePermission::getPermissionCode)
        .collect(Collectors.toList());
    List<RolePermissionResponse> result = allPermissions.stream()
        .map(p -> rolePermissionCodes.contains(p.getCode())
            ? new RolePermissionResponse(p.getCode(), p.getRemark(), p.getGroupName(), Boolean.TRUE)
            : new RolePermissionResponse(p.getCode(), p.getRemark(), p.getGroupName(),
                Boolean.FALSE))
        .collect(Collectors.toList());
    return ResponseData.success(result);
  }

  @PutMapping("updateRoleInfo/{id}")
  public ResponseData<?> updateRoleInfo(@PathVariable Long id,
      @RequestBody UpdateRoleInfoRequest request) {
    commands().send(UpdateRoleInfoCmd.Request.builder()
        .roleId(id)
        .name(request.getName())
        .description(request.getDescription())
        .build()
    );
    return ResponseData.success("ok");
  }

  @PutMapping("updateRolePermissions/{id}")
  public ResponseData<?> updateRolePermissions(@PathVariable Long id,
      @RequestBody List<String> permissionCodes) {
    List<Permission> allPermissions = Permission.getAllPermissions();
    List<RolePermission> permissionsToBeAssigned = allPermissions.stream()
        .filter(x -> permissionCodes.contains(x.getCode()))
        .map(p ->
            RolePermission.builder()
                .permissionCode(p.getCode())
                .permissionRemark(p.getRemark())
                .build()
        )
        .collect(Collectors.toList());
    commands().send(UpdateRolePermissionsCmd.Request.builder()
        .roleId(id)
        .permissions(permissionsToBeAssigned)
        .build());
    return ResponseData.success("ok");
  }

  @DeleteMapping("{id}")
  public ResponseData<?> deleteRole(@PathVariable Long id) {
    commands().send(DeleteRoleCmd.Request.builder()
        .roleId(id)
        .build());
    return ResponseData.success("ok");
  }
}
