package com.only4.domain.aggregates.customer_permission.factory;

import com.only4.domain.aggregates.customer_permission.CustomerPermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * CustomerPermission工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/26
 */
@Aggregate(aggregate = "CustomerPermission", name = "CustomerPermissionPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPermissionPayload implements AggregatePayload<CustomerPermission> {
    String name;

}
