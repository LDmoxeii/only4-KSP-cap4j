package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.OrderMapper;
import com.only4.application.queries.order.ExistedByIdQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedByIdQry查询请求适配实现 </br>
 * 根据 订单ID 判断订单是否存在，返回一个Boolean
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExistedOrderByIdQryHandler implements Query<ExistedByIdQry.Request, ExistedByIdQry.Response> {
    private final OrderMapper orderMapper;
    @Override
    public ExistedByIdQry.Response exec(ExistedByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = orderMapper.existedOrderById(request.getId());
        return ExistedByIdQry.Response.builder()
                .existed(isExists)
                .build();
    }
}