package com.only4.domain.aggregates.customer.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
@Builder
public class AssignCustomerRoleDto {
    private final Long roleId;
    private final String roleName;
}
