package com.only4.domain.aggregates.article_statistics.factory;

import com.only4.domain.aggregates.article_statistics.ArticleStatistics;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleStatistics聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "ArticleStatistics", name = "ArticleStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleStatisticsFactory implements AggregateFactory<ArticleStatisticsPayload, ArticleStatistics> {

    @Override
    public ArticleStatistics create(ArticleStatisticsPayload payload) {

        return ArticleStatistics.builder()

                .build();
    }
}
