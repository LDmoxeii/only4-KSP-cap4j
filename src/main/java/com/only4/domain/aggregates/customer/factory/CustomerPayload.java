package com.only4.domain.aggregates.customer.factory;

import com.only4.domain.aggregates.customer.Customer;
import com.only4.domain.aggregates.customer.dto.AssignCustomerRoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

import java.util.List;

/**
 * Customer工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "customer", name = "CustomerPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPayload implements AggregatePayload<Customer> {
    String account;
    String password;
    List<AssignCustomerRoleDto> rolesToBeAssigned;
}
