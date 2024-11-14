package com.only4.domain.aggregates.role.factory;

import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;

import java.util.List;

/**
 * Role工厂负载
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "role", name = "RolePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolePayload implements AggregatePayload<Role> {

    String name;

    String description;

    List<RolePermission> permissions;

}
