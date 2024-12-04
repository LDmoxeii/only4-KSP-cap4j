package com.only4.domain.aggregates.star_statistics.factory;

import com.only4.domain.aggregates.star_statistics.StarStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * StarStatistics聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "StarStatistics", name = "StarStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarStatisticsFactory implements AggregateFactory<StarStatisticsFactory.Payload, StarStatistics> {

    @Override
    public StarStatistics create(Payload payload) {

        return StarStatistics.builder()

                .build();
    }
    
    /**
     * StarStatistics工厂负载
     */
    @Aggregate(aggregate = "StarStatistics", name = "StarStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<StarStatistics> {
        String name;

    }
}