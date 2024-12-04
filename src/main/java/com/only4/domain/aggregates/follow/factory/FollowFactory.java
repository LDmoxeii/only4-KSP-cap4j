package com.only4.domain.aggregates.follow.factory;

import com.only4.domain.aggregates.follow.Follow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Follow聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Follow", name = "FollowFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class FollowFactory implements AggregateFactory<FollowFactory.Payload, Follow> {

    @Override
    public Follow create(Payload payload) {

        return Follow.builder()
                .followerId(payload.getFollowerId())
                .followedId(payload.getFollowedId())
                .build();
    }

    /**
     * Follow工厂负载
     */
    @Aggregate(aggregate = "Follow", name = "FollowPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Follow> {
        Long followerId;
        Long followedId;

    }
}
