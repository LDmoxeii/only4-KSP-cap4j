package com.only4.application.queries.admin_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;


/**
 * ExistedAdminUserByRoleIdQry查询请求参数
 * todo: 查询描述
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExistedAdminUserByRoleIdQryRequest implements RequestParam<ExistedAdminUserByRoleIdQryResponse> {
    Long roleId;
}
