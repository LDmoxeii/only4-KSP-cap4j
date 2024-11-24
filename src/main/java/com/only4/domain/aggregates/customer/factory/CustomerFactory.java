package com.only4.domain.aggregates.customer.factory;

import com.only4.domain.aggregates.customer.Customer;
import com.only4.domain.aggregates.customer.CustomerPermission;
import com.only4.domain.aggregates.customer.CustomerRole;
import com.only4.domain.aggregates.customer.dto.AssignCustomerRoleDto;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer聚合工厂
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "customer", name = "CustomerFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class CustomerFactory implements AggregateFactory<CustomerPayload, Customer> {

    private List<CustomerRole> customerRoles;
    private List<CustomerPermission> customerPermissions;

    @Override
    public Customer create(CustomerPayload payload) {
        resolveParameter(payload.getRolesToBeAssigned());
        return Customer.builder()
                .account(payload.getAccount())
                .password(payload.getPassword())
                .customerRoles(customerRoles)
                .customerPermissions(customerPermissions)
                .build();
    }

    private void resolveParameter(List<AssignCustomerRoleDto> rolesToBeAssigned) {
        this.customerRoles = new ArrayList<>();
        this.customerPermissions = new ArrayList<>();
        for (AssignCustomerRoleDto roleDto : rolesToBeAssigned) {
            this.customerRoles.add(
                    CustomerRole.builder()
                            .roleId(roleDto.getRoleId())
                            .roleName(roleDto.getRoleName())
                            .build());
            for (CustomerPermission permission : roleDto.getPermissions()) {
                permission.getSourceRoleIds().add(roleDto.getRoleId());
                this.customerPermissions.add(permission);
            }
        }
    }
}
