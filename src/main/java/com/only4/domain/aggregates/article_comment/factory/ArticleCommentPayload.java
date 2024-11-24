package com.only4.domain.aggregates.article_comment.factory;

import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.ArticleCommentStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * ArticleComment工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "article_comment", name = "ArticleCommentPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommentPayload implements AggregatePayload<ArticleComment> {
    Long articleId;
    Long authorId;
    String content;
    ArticleCommentStatistics statistics;

}
