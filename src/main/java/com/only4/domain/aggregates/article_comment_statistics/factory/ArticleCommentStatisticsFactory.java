package com.only4.domain.aggregates.article_comment_statistics.factory;

import com.only4.domain.aggregates.article_comment_statistics.ArticleCommentStatistics;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentStatistics聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "ArticleCommentStatistics", name = "ArticleCommentStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentStatisticsFactory implements AggregateFactory<ArticleCommentStatisticsPayload, ArticleCommentStatistics> {

    @Override
    public ArticleCommentStatistics create(ArticleCommentStatisticsPayload payload) {

        return ArticleCommentStatistics.builder()

                .build();
    }
}
