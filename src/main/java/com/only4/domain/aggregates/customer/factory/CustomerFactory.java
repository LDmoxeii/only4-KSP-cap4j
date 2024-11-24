package com.only4.domain.aggregates.customer.factory;

import com.only4.domain.aggregates.customer.Customer;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Customer聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "customer", name = "CustomerFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerFactory implements AggregateFactory<CustomerPayload, Customer> {

    @Override
    public Customer create(CustomerPayload payload) {

        return Customer.builder()

                .build();
    }
}
