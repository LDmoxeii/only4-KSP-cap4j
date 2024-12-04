package com.only4.domain.aggregates.article_comment_statistics.factory;

import com.only4.domain.aggregates.article_comment_statistics.ArticleCommentStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentStatistics聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "ArticleCommentStatistics", name = "ArticleCommentStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentStatisticsFactory implements AggregateFactory<ArticleCommentStatisticsFactory.Payload, ArticleCommentStatistics> {

    @Override
    public ArticleCommentStatistics create(Payload payload) {

        return ArticleCommentStatistics.builder()

                .build();
    }
    
    /**
     * ArticleCommentStatistics工厂负载
     */
    @Aggregate(aggregate = "ArticleCommentStatistics", name = "ArticleCommentStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ArticleCommentStatistics> {
        String name;

    }
}