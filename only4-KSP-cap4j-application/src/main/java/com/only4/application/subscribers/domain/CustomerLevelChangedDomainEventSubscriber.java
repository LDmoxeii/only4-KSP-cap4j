package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.customer.events.CustomerLevelChangedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Customer.CustomerLevelChangedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CustomerLevelChangedDomainEventSubscriber {

    @EventListener(CustomerLevelChangedDomainEvent.class)
    public void on(CustomerLevelChangedDomainEvent event) {
        
    }

}
