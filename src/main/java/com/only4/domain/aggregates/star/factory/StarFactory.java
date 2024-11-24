package com.only4.domain.aggregates.star.factory;

import com.only4.domain.aggregates.star.Star;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Star聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "star", name = "StarFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarFactory implements AggregateFactory<StarPayload, Star> {

    @Override
    public Star create(StarPayload payload) {

        return Star.builder()
                .masterId(payload.getMasterId())
                .name(payload.getName())
                .description(payload.getDescription())
                .starStatistics(Collections.singletonList(payload.getStarStatistics()))
                .build();
    }
}
