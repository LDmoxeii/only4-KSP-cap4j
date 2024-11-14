package com.only4.domain.aggregates.admin_user.factory;

import com.only4.domain.aggregates.admin_user.AdminUser;
import com.only4.domain.aggregates.admin_user.dto.AssignAdminUserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;

import java.util.List;

/**
 * AdminUser工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "admin_user", name = "AdminUserPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserPayload implements AggregatePayload<AdminUser> {
    String name;
    String phone;
    String password;
    List<AssignAdminUserRoleDto> rolesToBeAssigned;
}
