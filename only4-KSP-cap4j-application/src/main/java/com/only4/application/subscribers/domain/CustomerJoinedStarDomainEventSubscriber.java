package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.stardust.events.CustomerJoinedStarDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Stardust.CustomerJoinedStarDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CustomerJoinedStarDomainEventSubscriber {

    @EventListener(CustomerJoinedStarDomainEvent.class)
    public void on(CustomerJoinedStarDomainEvent event) {
        
    }

}
