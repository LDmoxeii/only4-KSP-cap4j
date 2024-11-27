package com.only4.domain.aggregates.article_statistics.factory;

import com.only4.domain.aggregates.article_statistics.ArticleStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * ArticleStatistics工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "ArticleStatistics", name = "ArticleStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleStatisticsPayload implements AggregatePayload<ArticleStatistics> {
    String name;

}
