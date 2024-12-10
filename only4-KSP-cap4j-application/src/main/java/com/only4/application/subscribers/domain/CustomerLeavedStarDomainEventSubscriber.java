package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.stardust.events.CustomerLeavedStarDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Stardust.CustomerLeavedStarDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CustomerLeavedStarDomainEventSubscriber {

    @EventListener(CustomerLeavedStarDomainEvent.class)
    public void on(CustomerLeavedStarDomainEvent event) {
        
    }

}