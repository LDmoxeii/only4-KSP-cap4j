package com.only4.domain.aggregates.customer.factory;

import com.only4.domain.aggregates.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Customer聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Customer", name = "CustomerFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerFactory implements AggregateFactory<CustomerFactory.Payload, Customer> {

    @Override
    public Customer create(Payload payload) {

        return Customer.builder()
                .account(payload.getAccount())
                .password(payload.getPassword())
                .build();
    }

    /**
     * Customer工厂负载
     */
    @Aggregate(aggregate = "Customer", name = "CustomerPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Customer> {
        String account;
        String password;

    }
}
