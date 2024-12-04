package com.only4.domain.aggregates.star.factory;

import com.only4.domain.aggregates.star.Star;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Star聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Star", name = "StarFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarFactory implements AggregateFactory<StarFactory.Payload, Star> {

    @Override
    public Star create(Payload payload) {

        return Star.builder()
                .masterId(payload.getMasterId())
                .name(payload.getName())
                .description(payload.getDescription())
                .build();
    }

    /**
     * Star工厂负载
     */
    @Aggregate(aggregate = "Star", name = "StarPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Star> {
        Long masterId;

        String name;

        String description;

    }
}
