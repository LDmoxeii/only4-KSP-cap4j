package com.only4.application.queries.role;

import com.only4.domain.aggregates.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetRolesByIdQry查询响应
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRolesByIdQryResponse {
    Role role;
}
