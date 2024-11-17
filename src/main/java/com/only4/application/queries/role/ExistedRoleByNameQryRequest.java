package com.only4.application.queries.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;


/**
 * ExistedRoleByNameQry查询请求参数
 * todo: 查询描述
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExistedRoleByNameQryRequest implements RequestParam<ExistedRoleByNameQryResponse> {
    String name;
}
