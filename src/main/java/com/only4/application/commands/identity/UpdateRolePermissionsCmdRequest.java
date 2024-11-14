package com.only4.application.commands.identity;

import com.only4.domain.aggregates.role.RolePermission;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * UpdateRolepermissionsCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRolePermissionsCmdRequest implements
    RequestParam<UpdateRolePermissionsCmdResponse> {

  Long roleId;

  List<RolePermission> permissions;

}
