package com.only4.domain.aggregates.customer_permission.factory;

import com.only4.domain.aggregates.customer_permission.CustomerPermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * CustomerPermission聚合工厂
 * 
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "CustomerPermission", name = "CustomerPermissionFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerPermissionFactory implements AggregateFactory<CustomerPermissionFactory.Payload, CustomerPermission> {

    @Override
    public CustomerPermission create(Payload payload) {

        return CustomerPermission.builder()

                .build();
    }
    
    /**
     * CustomerPermission工厂负载
     */
    @Aggregate(aggregate = "CustomerPermission", name = "CustomerPermissionPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<CustomerPermission> {
        String name;

    }
}