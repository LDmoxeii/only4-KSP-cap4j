package com.only4.domain.aggregates.article_comment.factory;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * ArticleComment聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "article_comment", name = "ArticleCommentFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentFactory implements AggregateFactory<ArticleCommentPayload, ArticleComment> {

    @Override
    public ArticleComment create(ArticleCommentPayload payload) {

        return ArticleComment.builder()

                .build();
    }
}
