package com.only4.domain.aggregates.customer_permission.factory;

import com.only4.domain.aggregates.customer_permission.CustomerPermission;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * CustomerPermission聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "CustomerPermission", name = "CustomerPermissionFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerPermissionFactory implements AggregateFactory<CustomerPermissionPayload, CustomerPermission> {

    @Override
    public CustomerPermission create(CustomerPermissionPayload payload) {

        return CustomerPermission.builder()

                .build();
    }
}
