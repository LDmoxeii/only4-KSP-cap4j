package com.only4.domain.aggregates.role.events;

import com.only4.domain.aggregates.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Role.RoleInfoUpdatedDomainEvent领域事件
 * 角色信息已更新
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/20
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Role", name = "RoleInfoUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfoUpdatedDomainEvent {
    Role entity;
}
