package com.only4.domain.aggregates.article_comment.factory;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleComment聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "ArticleComment", name = "ArticleCommentFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentFactory implements AggregateFactory<ArticleCommentFactory.Payload, ArticleComment> {

    @Override
    public ArticleComment create(Payload payload) {

        return ArticleComment.builder()

                .build();
    }

    /**
     * ArticleComment工厂负载
     */
    @Aggregate(aggregate = "ArticleComment", name = "ArticleCommentPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ArticleComment> {
        Long articleId;
        Long authorId;
        String content;

    }
}
