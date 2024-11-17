package com.only4.application.queries.admin_user;

import com.only4.domain.aggregates.admin_user.AdminUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetAdminUserByIdQry查询响应
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAdminUserByIdQryResponse {
    private AdminUser adminUser;

}
