package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.customer.events.CustomerCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Customer.CustomerCreatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CustomerCreatedDomainEventSubscriber {

    @EventListener(CustomerCreatedDomainEvent.class)
    public void on(CustomerCreatedDomainEvent event) {
        
    }

}
