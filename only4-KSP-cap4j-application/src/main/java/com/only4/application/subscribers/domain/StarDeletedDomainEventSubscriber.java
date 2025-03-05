package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star.events.StarDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Star.StarDeletedDomainEvent领域事件订阅
 * 星球已删除
 */
@Service
@RequiredArgsConstructor
public class StarDeletedDomainEventSubscriber {

    @EventListener(StarDeletedDomainEvent.class)
    public void on(StarDeletedDomainEvent event) {
        
    }

}
