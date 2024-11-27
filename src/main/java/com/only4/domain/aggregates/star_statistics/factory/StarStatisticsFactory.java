package com.only4.domain.aggregates.star_statistics.factory;

import com.only4.domain.aggregates.star_statistics.StarStatistics;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * StarStatistics聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "StarStatistics", name = "StarStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarStatisticsFactory implements AggregateFactory<StarStatisticsPayload, StarStatistics> {

    @Override
    public StarStatistics create(StarStatisticsPayload payload) {

        return StarStatistics.builder()

                .build();
    }
}
