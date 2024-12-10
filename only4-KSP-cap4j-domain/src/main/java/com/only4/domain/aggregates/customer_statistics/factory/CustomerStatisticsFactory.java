package com.only4.domain.aggregates.customer_statistics.factory;

import com.only4.domain.aggregates.customer_statistics.CustomerStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * CustomerStatistics聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "CustomerStatistics", name = "CustomerStatisticsFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerStatisticsFactory implements AggregateFactory<CustomerStatisticsFactory.Payload, CustomerStatistics> {

    @Override
    public CustomerStatistics create(Payload payload) {

        return CustomerStatistics.builder()

                .build();
    }
    
    /**
     * CustomerStatistics工厂负载
     */
    @Aggregate(aggregate = "CustomerStatistics", name = "CustomerStatisticsPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<CustomerStatistics> {
        String name;

    }
}