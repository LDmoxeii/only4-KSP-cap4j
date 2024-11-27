package com.only4.domain.aggregates.customer_statistics.factory;

import com.only4.domain.aggregates.customer_statistics.CustomerStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * CustomerStatistics工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "customer_statistics", name = "CustomerStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStatisticsPayload implements AggregatePayload<CustomerStatistics> {
    String name;

}
