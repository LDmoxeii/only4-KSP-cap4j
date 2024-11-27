package com.only4.domain.aggregates.article_comment_like.factory;

import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * ArticleCommentLike工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "ArticleCommentLike", name = "ArticleCommentLikePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommentLikePayload implements AggregatePayload<ArticleCommentLike> {
    Long customerId;
    Long commentId;

}
