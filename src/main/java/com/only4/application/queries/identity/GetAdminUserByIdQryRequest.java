package com.only4.application.queries.identity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;


/**
 * GetAdminUserByIdQry查询请求参数
 * todo: 查询描述
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAdminUserByIdQryRequest implements RequestParam<GetAdminUserByIdQryResponse> {
    Long id;
}