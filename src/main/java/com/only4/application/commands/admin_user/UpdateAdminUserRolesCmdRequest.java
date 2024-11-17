package com.only4.application.commands.admin_user;

import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * UpdateAdminUserRolesCmd命令请求参数
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminUserRolesCmdRequest implements
    RequestParam<UpdateAdminUserRolesCmdResponse> {

  Long adminUserId;

  @NotEmpty
  public List<AssignAdminUserRoleDto> rolesToBeAssigned;

}
