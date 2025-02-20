package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.role.events.RoleInfoUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Role.RoleInfoUpdatedDomainEvent领域事件订阅
 * 角色信息已更新
 */
@Service
@RequiredArgsConstructor
public class RoleInfoUpdatedDomainEventSubscriber {

    @EventListener(RoleInfoUpdatedDomainEvent.class)
    public void on(RoleInfoUpdatedDomainEvent event) {
        
    }

}
