package com.only4.domain.aggregates.article_like.factory;

import com.only4.domain.aggregates.article_like.ArticleLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "ArticleLike", name = "ArticleLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleLikeFactory implements AggregateFactory<ArticleLikeFactory.Payload, ArticleLike> {

    @Override
    public ArticleLike create(Payload payload) {

        return ArticleLike.builder()
                .customerId(payload.getCustomerId())
                .articleId(payload.getArticleId())
                .build();
    }

    /**
     * ArticleLike工厂负载
     */
    @Aggregate(aggregate = "ArticleLike", name = "ArticleLikePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ArticleLike> {
        Long CustomerId;
        Long ArticleId;
    }
}