package com.only4.domain.aggregates.article_comment_like.factory;

import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "article_comment_like", name = "ArticleCommentLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentLikeFactory implements AggregateFactory<ArticleCommentLikePayload, ArticleCommentLike> {

    @Override
    public ArticleCommentLike create(ArticleCommentLikePayload payload) {

        return ArticleCommentLike.builder()

                .build();
    }
}
