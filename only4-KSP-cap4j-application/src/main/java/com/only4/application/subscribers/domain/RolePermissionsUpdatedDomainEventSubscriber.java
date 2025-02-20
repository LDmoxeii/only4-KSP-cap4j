package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.role.events.RolePermissionsUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Role.RolePermissionsUpdatedDomainEvent领域事件订阅
 * 角色权限集已更新
 */
@Service
@RequiredArgsConstructor
public class RolePermissionsUpdatedDomainEventSubscriber {

    @EventListener(RolePermissionsUpdatedDomainEvent.class)
    public void on(RolePermissionsUpdatedDomainEvent event) {
        
    }

}
