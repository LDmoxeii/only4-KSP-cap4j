package com.only4.domain.aggregates.star_comment_statistics.factory;

import com.only4.domain.aggregates.star_comment_statistics.StarCommentStatistics;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * StarCommentStatistics聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "StarCommentStatistics", name = "StarCommentStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class StarCommentStatisticsFactory implements AggregateFactory<StarCommentStatisticsPayload, StarCommentStatistics> {

    @Override
    public StarCommentStatistics create(StarCommentStatisticsPayload payload) {

        return StarCommentStatistics.builder()

                .build();
    }
}
