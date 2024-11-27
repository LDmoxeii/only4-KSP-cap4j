package com.only4.domain.aggregates.star_comment_statistics.factory;

import com.only4.domain.aggregates.star_comment_statistics.StarCommentStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * StarCommentStatistics工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "StarCommentStatistics", name = "StarCommentStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarCommentStatisticsPayload implements AggregatePayload<StarCommentStatistics> {
    String name;

}
