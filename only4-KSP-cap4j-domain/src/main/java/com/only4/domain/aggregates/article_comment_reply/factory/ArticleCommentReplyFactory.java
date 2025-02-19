package com.only4.domain.aggregates.article_comment_reply.factory;

import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReplyStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

/**
 * ArticleCommentReply聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@Aggregate(aggregate = "ArticleCommentReply", name = "ArticleCommentReplyFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleCommentReplyFactory implements AggregateFactory<ArticleCommentReplyFactory.Payload, ArticleCommentReply> {

    @Override
    public ArticleCommentReply create(Payload payload) {

        return ArticleCommentReply.builder()
                .articleCommentId(payload.getCommentId())
                .authorId(payload.getMemberId())
                .authorName(payload.getMemberName())
                .content(payload.getContent())
                .articleCommentReplyStatistics(Collections.singletonList(new ArticleCommentReplyStatistics()))
                .createAt(LocalDateTime.now())
                .build();
    }

    /**
     * ArticleCommentReply工厂负载
     */
    @Aggregate(aggregate = "ArticleCommentReply", name = "ArticleCommentReplyPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<ArticleCommentReply> {

        Long commentId;

        Long memberId;

        String memberName;

        String content;

    }
}
