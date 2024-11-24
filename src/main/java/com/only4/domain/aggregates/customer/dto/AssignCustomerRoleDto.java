package com.only4.domain.aggregates.customer.dto;

import com.only4.domain.aggregates.customer.CustomerPermission;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
@Builder
public class AssignCustomerRoleDto {
    private final Long roleId;
    private final String roleName;
    private final List<CustomerPermission> permissions;
}
