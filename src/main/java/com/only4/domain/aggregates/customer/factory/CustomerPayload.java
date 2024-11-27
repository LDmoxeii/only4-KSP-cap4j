package com.only4.domain.aggregates.customer.factory;

import com.only4.domain.aggregates.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * Customer工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "Customer", name = "CustomerPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPayload implements AggregatePayload<Customer> {
    String account;
    String password;
}
