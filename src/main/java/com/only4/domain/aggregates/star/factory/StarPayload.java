package com.only4.domain.aggregates.star.factory;

import com.only4.domain.aggregates.star.Star;
import com.only4.domain.aggregates.star.StarStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * Star工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "star", name = "StarPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarPayload implements AggregatePayload<Star> {

    Long masterId;

    String name;

    String description;

    StarStatistics starStatistics;

}
