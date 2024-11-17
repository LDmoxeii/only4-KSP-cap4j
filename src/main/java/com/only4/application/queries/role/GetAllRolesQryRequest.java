package com.only4.application.queries.role;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;


/**
 * GetAllRolesQry查询请求参数
 * todo: 查询描述
 */
@Data
@Builder
@NoArgsConstructor
public class GetAllRolesQryRequest implements RequestParam<GetAllRolesQryResponse> {
}
