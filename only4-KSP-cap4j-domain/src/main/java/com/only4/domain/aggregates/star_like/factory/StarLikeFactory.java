package com.only4.domain.aggregates.star_like.factory;

import com.only4.domain.aggregates.star_like.StarLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * StarLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/17
 */
@Aggregate(aggregate = "StarLike", name = "StarLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarLikeFactory implements AggregateFactory<StarLikeFactory.Payload, StarLike> {

    @Override
    public StarLike create(Payload payload) {

        return StarLike.builder()

                .build();
    }

    /**
     * StarLike工厂负载
     */
    @Aggregate(aggregate = "StarLike", name = "StarLikePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<StarLike> {
        String name;

    }
}
