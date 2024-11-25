package com.only4.application.commands.admin_user;

import com.only4.domain.aggregates.admin_user.AdminUserPermission;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * UpdateAdminUserRolePermissionsCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminUserRolePermissionsCmdRequest implements
    RequestParam<UpdateAdminUserRolePermissionsCmdResponse> {

  Long roleId;

  Long adminUserId;

  List<AdminUserPermission> permissions;

}
