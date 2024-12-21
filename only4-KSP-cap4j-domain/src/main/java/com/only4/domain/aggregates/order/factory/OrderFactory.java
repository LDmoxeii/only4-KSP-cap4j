package com.only4.domain.aggregates.order.factory;

import com.only4.domain.aggregates.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Order聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Order", name = "OrderFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class OrderFactory implements AggregateFactory<OrderFactory.Payload, Order> {

    @Override
    public Order create(Payload payload) {
        return Order.builder()
                .id(payload.customerId)
                .price(payload.price)
                .amount(payload.amount)
                .state(payload.state)
                .build();
    }

    /**
     * Order工厂负载
     */
    @Aggregate(aggregate = "Order", name = "OrderPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Order> {
        Long customerId;
        Integer amount;
        Integer price;
        Integer state;

    }
}
