package com.only4.domain.aggregates.role.factory;

import com.only4.domain.aggregates.role.Role;
import com.only4.domain.aggregates.role.RolePermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Role聚合工厂
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Role", name = "RoleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class RoleFactory implements AggregateFactory<RoleFactory.Payload, Role> {

    @Override
    public Role create(Payload payload) {

        return Role.builder()
                .rolePermissions(payload.permissions)
                .name(payload.name)
                .description(payload.description)
                .createdAt(LocalDateTime.now())
                .delFlag(false)
                .build();
    }

    /**
     * Role工厂负载
     */
    @Aggregate(aggregate = "Role", name = "RolePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Role> {
        String name;

        String description;

        List<RolePermission> permissions;

    }
}
