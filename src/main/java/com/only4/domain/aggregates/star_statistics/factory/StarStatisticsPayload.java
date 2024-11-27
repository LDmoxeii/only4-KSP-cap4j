package com.only4.domain.aggregates.star_statistics.factory;

import com.only4.domain.aggregates.star_statistics.StarStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * StarStatistics工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "StarStatistics", name = "StarStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarStatisticsPayload implements AggregatePayload<StarStatistics> {
    String name;

}
