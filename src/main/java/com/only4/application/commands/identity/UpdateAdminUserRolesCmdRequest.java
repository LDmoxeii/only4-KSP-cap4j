package com.only4.application.commands.identity;

import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

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
public class UpdateAdminUserRolesCmdRequest implements RequestParam<UpdateAdminUserRolesCmdResponse> {

    @NotNull
    Long adminUserId;

    @NotNull
    public List<AssignAdminUserRoleDto> rolesToBeAssigned;

}
