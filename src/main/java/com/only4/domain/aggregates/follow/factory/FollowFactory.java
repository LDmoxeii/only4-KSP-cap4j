package com.only4.domain.aggregates.follow.factory;

import com.only4.domain.aggregates.follow.Follow;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Follow聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "follow", name = "FollowFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class FollowFactory implements AggregateFactory<FollowPayload, Follow> {

    @Override
    public Follow create(FollowPayload payload) {

        return Follow.builder()

                .build();
    }
}
