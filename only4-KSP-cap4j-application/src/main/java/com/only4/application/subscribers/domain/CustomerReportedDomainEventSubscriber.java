package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.customer.events.CustomerReportedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Customer.CustomerReportedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CustomerReportedDomainEventSubscriber {

    @EventListener(CustomerReportedDomainEvent.class)
    public void on(CustomerReportedDomainEvent event) {
        
    }

}
