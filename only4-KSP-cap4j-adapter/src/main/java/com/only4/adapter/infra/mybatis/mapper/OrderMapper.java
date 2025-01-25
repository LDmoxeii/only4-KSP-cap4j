package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.order.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Boolean existedOrderByOrderId(Long id);
    Order getOrderById(Long id);
}
