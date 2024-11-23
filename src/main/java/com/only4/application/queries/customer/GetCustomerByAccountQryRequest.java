package com.only4.application.queries.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;


/**
 * GetCustomerByAccountQry查询请求参数
 * todo: 查询描述
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerByAccountQryRequest implements RequestParam<GetCustomerByAccountQryResponse> {
    String account;
}
