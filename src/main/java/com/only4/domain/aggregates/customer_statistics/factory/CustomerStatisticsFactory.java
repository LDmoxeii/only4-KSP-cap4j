package com.only4.domain.aggregates.customer_statistics.factory;

import com.only4.domain.aggregates.customer_statistics.CustomerStatistics;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * CustomerStatistics聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "customer_statistics", name = "CustomerStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerStatisticsFactory implements AggregateFactory<CustomerStatisticsPayload, CustomerStatistics> {

    @Override
    public CustomerStatistics create(CustomerStatisticsPayload payload) {

        return CustomerStatistics.builder()

                .build();
    }
}
