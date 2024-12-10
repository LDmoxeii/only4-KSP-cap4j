package com.only4.domain.aggregates.stardust.factory;

import com.only4.domain.aggregates.stardust.Stardust;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Stardust聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Stardust", name = "StardustFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StardustFactory implements AggregateFactory<StardustFactory.Payload, Stardust> {

    @Override
    public Stardust create(Payload payload) {

        return Stardust.builder()
                .starId(payload.getStarId())
                .customerId(payload.getCustomerId())
                .build();
    }

    /**
     * Stardust工厂负载
     */
    @Aggregate(aggregate = "Stardust", name = "StardustPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Stardust> {
        Long StarId;
        Long CustomerId;

    }
}
