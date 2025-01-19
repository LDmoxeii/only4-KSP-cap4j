package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.OrderMapper;
import com.only4.application.queries.order.GetOrderByIdQry;
import com.only4.domain.aggregates.order.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * GetOrderByIdQry查询请求适配实现
 * todo: 查询描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GetOrderByIdQryHandler implements Query<GetOrderByIdQry.Request, GetOrderByIdQry.Response> {
    private final OrderMapper orderMapper;
    @Override
    public GetOrderByIdQry.Response exec(GetOrderByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Order order = orderMapper.getOrderById(request.getId());
        return GetOrderByIdQry.Response.builder()
                .order(order)
                .build();
    }
}