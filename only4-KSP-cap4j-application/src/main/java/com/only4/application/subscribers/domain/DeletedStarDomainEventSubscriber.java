package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star.events.DeletedStarDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Star.DeletedStarDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class DeletedStarDomainEventSubscriber {

    @EventListener(DeletedStarDomainEvent.class)
    public void on(DeletedStarDomainEvent event) {
        
    }

}
