package com.only4.domain.aggregates.article_like.factory;

import com.only4.domain.aggregates.article_like.ArticleLike;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "article_like", name = "ArticleLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleLikeFactory implements AggregateFactory<ArticleLikePayload, ArticleLike> {

    @Override
    public ArticleLike create(ArticleLikePayload payload) {

        return ArticleLike.builder()

                .build();
    }
}
