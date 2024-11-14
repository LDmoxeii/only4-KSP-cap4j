package com.only4.adapter.portal.api;

import com.only4._share.exception.KnownException;
import com.only4.adapter.portal.api._share.ResponseData;
import com.only4.adapter.portal.api.request.CreateRoleRequest;
import com.only4.adapter.portal.api.request.UpdateRoleInfoRequest;
import com.only4.adapter.portal.api.response.RolePermissionResponse;
import com.only4.adapter.portal.api.response.RoleResponse;
import com.only4.application.commands.identity.*;
import com.only4.application.queries.identity.GetAllRolesQryRequest;
import com.only4.application.queries.identity.GetRolesByConditionQryRequest;
import com.only4.application.queries.identity.GetRolesByIdQryRequest;
import com.only4.domain.aggregates.permission.Permission;
import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author LD_moxeii
 */
@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {
    @PostMapping("createRole")
    public ResponseData<?> createRole(@RequestBody @Validated CreateRoleRequest request) {
        List<Permission> allPermissions = Permission.getAllPermissions();
        List<RolePermission> permissionsToBeAssigned = allPermissions.stream()
                .filter(p -> request.getPermissionCodes().contains(p.getCode()))
                .map(p -> new RolePermission(p.getCode(), p.getRemark()))
                .collect(Collectors.toList());
        var send = Mediator.commands().send(
                CreateRoleCmdRequest.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .permissions(permissionsToBeAssigned)
                        .build()
        );
        return ResponseData.success(send);
    }

    @GetMapping("getAllRoles")
    public ResponseData<?> getAllRoles() {
        var send = Mediator.queries().send(new GetAllRolesQryRequest());
        List<RoleResponse> result = send.getRoles().stream()
                .map(RoleResponse::new)
                .collect(Collectors.toList());
        return ResponseData.success(result);
    }

    @GetMapping("getRoleByCondition")
    public ResponseData<?> getRoleByCondition(@RequestBody CreateRoleRequest request) {
        var send = Mediator.queries().send(
                GetRolesByConditionQryRequest.builder()
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
        var send = Mediator.queries().send(
                GetRolesByIdQryRequest.builder()
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
        var send = Mediator.queries().send(new GetRolesByIdQryRequest(id));
        Role role = Optional.ofNullable(send.getRole())
                .orElseThrow(() -> new KnownException("未找到角色， RoleId =" + id));
        List<Permission> allPermissions = Permission.getAllPermissions();
        List<String> rolePermissionCodes = role.getRolePermissions().stream()
                .map(RolePermission::getPermissionCode)
                .collect(Collectors.toList());
        List<RolePermissionResponse> result = allPermissions.stream()
                .map(p -> rolePermissionCodes.contains(p.getCode())
                        ? new RolePermissionResponse(p.getCode(), p.getRemark(), p.getGroupName(), Boolean.TRUE)
                        : new RolePermissionResponse(p.getCode(), p.getRemark(), p.getGroupName(), Boolean.FALSE))
                .collect(Collectors.toList());
        return ResponseData.success(result);
    }

    @PutMapping("updateRoleInfo/{id}")
    public ResponseData<?> updateRoleInfo(@PathVariable Long id, @RequestBody UpdateRoleInfoRequest request) {
        Mediator.commands().send(new UpdateRoleInfoCmdRequest(id, request.getName(), request.getDescription()));
        return ResponseData.success("ok");
    }

    @PutMapping("updateRolePermissions/{id}")
    public ResponseData<?> updateRolePermissions(@PathVariable Long id, @RequestBody List<String> permissionCodes) {
        List<Permission> allPermissions = Permission.getAllPermissions();
        List<RolePermission> permissionsToBeAssigned = allPermissions.stream()
                .filter(x -> permissionCodes.contains(x.getCode()))
                .map(p -> new RolePermission(p.getCode(), p.getRemark()))
                .collect(Collectors.toList());
        Mediator.commands().send(new UpdateRolePermissionsCmdRequest(id, permissionsToBeAssigned));
        return ResponseData.success("ok");
    }

    @DeleteMapping("{id}")
    public ResponseData<?> deleteRole(@PathVariable Long id) {
        Mediator.commands().send(new DeleteRoleCmdRequest(id));
        return ResponseData.success("ok");
    }
}
