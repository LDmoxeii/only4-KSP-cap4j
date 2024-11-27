package com.only4.domain.aggregates.customer_role.factory;

import com.only4.domain.aggregates.customer_role.CustomerRole;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * CustomerRole聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "CustomerRole", name = "CustomerRoleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerRoleFactory implements AggregateFactory<CustomerRolePayload, CustomerRole> {

    @Override
    public CustomerRole create(CustomerRolePayload payload) {

        return CustomerRole.builder()

                .build();
    }
}
