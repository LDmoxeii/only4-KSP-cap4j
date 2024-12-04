package com.only4.domain.aggregates.article_comment_like.factory;

import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentLike聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "ArticleCommentLike", name = "ArticleCommentLikeFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentLikeFactory implements AggregateFactory<ArticleCommentLikeFactory.Payload, ArticleCommentLike> {

    @Override
    public ArticleCommentLike create(Payload payload) {

        return ArticleCommentLike.builder()
                .customerId(payload.getCustomerId())
                .comments(payload.getCommentId())
                .build();
    }

    /**
     * ArticleCommentLike工厂负载
     */
    @Aggregate(aggregate = "ArticleCommentLike", name = "ArticleCommentLikePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ArticleCommentLike> {
        Long customerId;
        Long commentId;
    }
}
