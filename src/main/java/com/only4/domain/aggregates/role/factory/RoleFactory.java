package com.only4.domain.aggregates.role.factory;

import com.only4.domain.aggregates.role.Role;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Role聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/13
 */
@Aggregate(aggregate = "Role", name = "RoleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class RoleFactory implements AggregateFactory<RolePayload, Role> {

    @Override
    public Role create(RolePayload payload) {

        return Role.builder()
                .createdAt(LocalDateTime.now())
                .name(payload.name)
                .description(payload.description)
                .rolePermissions(payload.permissions)
                .build();
    }
}
