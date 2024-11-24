package com.only4.domain.aggregates.stardust.factory;

import com.only4.domain.aggregates.stardust.Stardust;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Stardust聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "stardust", name = "StardustFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StardustFactory implements AggregateFactory<StardustPayload, Stardust> {

    @Override
    public Stardust create(StardustPayload payload) {

        return Stardust.builder()
                .starId(payload.getStarId())
                .customerId(payload.getCustomerId())
                .build();
    }
}
