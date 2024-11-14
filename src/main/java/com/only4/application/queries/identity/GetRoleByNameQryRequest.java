package com.only4.application.queries.identity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;


/**
 * GetRoleByNameQry查询请求参数
 * todo: 查询描述
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRoleByNameQryRequest implements RequestParam<GetRoleByNameQryResponse> {
    String roleName;
}
