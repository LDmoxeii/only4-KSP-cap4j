package com.only4.domain.aggregates.order.factory;

import com.only4.domain.aggregates.order.Order;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Order聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "order", name = "OrderFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class OrderFactory implements AggregateFactory<OrderPayload, Order> {

    @Override
    public Order create(OrderPayload payload) {

        return Order.builder()

                .build();
    }
}
