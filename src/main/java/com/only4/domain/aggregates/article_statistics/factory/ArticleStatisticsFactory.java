package com.only4.domain.aggregates.article_statistics.factory;

import com.only4.domain.aggregates.article_statistics.ArticleStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleStatistics聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "ArticleStatistics", name = "ArticleStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleStatisticsFactory implements AggregateFactory<ArticleStatisticsFactory.Payload, ArticleStatistics> {

    @Override
    public ArticleStatistics create(Payload payload) {

        return ArticleStatistics.builder()

                .build();
    }
    
    /**
     * ArticleStatistics工厂负载
     */
    @Aggregate(aggregate = "ArticleStatistics", name = "ArticleStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ArticleStatistics> {
        String name;

    }
}