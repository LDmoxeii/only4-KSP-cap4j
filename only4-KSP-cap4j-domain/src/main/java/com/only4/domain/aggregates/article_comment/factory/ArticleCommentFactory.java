package com.only4.domain.aggregates.article_comment.factory;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.ArticleCommentStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * ArticleComment聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@Aggregate(aggregate = "ArticleComment", name = "ArticleCommentFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentFactory implements AggregateFactory<ArticleCommentFactory.Payload, ArticleComment> {

    @Override
    public ArticleComment create(Payload payload) {

        return ArticleComment.builder()
                .authorId(payload.getMemberId())
                .authorName(payload.getMemberName())
                .content(payload.getContent())
                .articleCommentStatistics(Collections.singletonList(new ArticleCommentStatistics()))
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

        Long memberId;

        String memberName;

        String content;

    }
}
