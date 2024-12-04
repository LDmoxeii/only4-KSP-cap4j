package com.only4.domain.aggregates.customer_role.factory;

import com.only4.domain.aggregates.customer_role.CustomerRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * CustomerRole聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "CustomerRole", name = "CustomerRoleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerRoleFactory implements AggregateFactory<CustomerRoleFactory.Payload, CustomerRole> {

    @Override
    public CustomerRole create(Payload payload) {

        return CustomerRole.builder()

                .build();
    }
    
    /**
     * CustomerRole工厂负载
     */
    @Aggregate(aggregate = "CustomerRole", name = "CustomerRolePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<CustomerRole> {
        String name;

    }
}