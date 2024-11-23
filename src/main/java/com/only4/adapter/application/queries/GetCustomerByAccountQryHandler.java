package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.CustomerMapper;
import com.only4.application.queries.customer.GetCustomerByAccountQryRequest;
import com.only4.application.queries.customer.GetCustomerByAccountQryResponse;
import com.only4.domain.aggregates.customer.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetCustomerByAccountQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/23
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetCustomerByAccountQryHandler implements Query<GetCustomerByAccountQryRequest, GetCustomerByAccountQryResponse> {
    private final CustomerMapper mapper;

    @Override
    public GetCustomerByAccountQryResponse exec(GetCustomerByAccountQryRequest request) {
        Customer customer =  mapper.getByAccount(request.getAccount());

        // mybatis / jpa 哪个顺手就用哪个吧！
        return GetCustomerByAccountQryResponse.builder()
            .customer(customer)
            .build();
    }
}
