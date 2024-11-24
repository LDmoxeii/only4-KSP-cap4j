package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.follow.events.FollowedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Follow.FollowedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class FollowedDomainEventSubscriber {

    @EventListener(FollowedDomainEvent.class)
    public void on(FollowedDomainEvent event) {
        
    }

}
