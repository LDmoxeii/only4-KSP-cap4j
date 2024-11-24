package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.customer.events.CustomerSignedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Customer.CustomerSignedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CustomerSignedDomainEventSubscriber {

    @EventListener(CustomerSignedDomainEvent.class)
    public void on(CustomerSignedDomainEvent event) {
        
    }

}
