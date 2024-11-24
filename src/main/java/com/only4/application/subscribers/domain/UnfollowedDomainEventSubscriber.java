package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.follow.events.UnfollowedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Follow.UnfollowedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UnfollowedDomainEventSubscriber {

    @EventListener(UnfollowedDomainEvent.class)
    public void on(UnfollowedDomainEvent event) {
        
    }

}