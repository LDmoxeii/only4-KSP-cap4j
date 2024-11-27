package com.only4.domain.aggregates.article_comment_statistics.factory;

import com.only4.domain.aggregates.article_comment_statistics.ArticleCommentStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * ArticleCommentStatistics工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "ArticleCommentStatistics", name = "ArticleCommentStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommentStatisticsPayload implements AggregatePayload<ArticleCommentStatistics> {
    String name;

}
