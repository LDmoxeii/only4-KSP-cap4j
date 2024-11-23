package com.only4.application.queries.customer;

import com.only4.domain.aggregates.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetCustomerByAccountQry查询响应
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerByAccountQryResponse {

    private Customer customer;

}
