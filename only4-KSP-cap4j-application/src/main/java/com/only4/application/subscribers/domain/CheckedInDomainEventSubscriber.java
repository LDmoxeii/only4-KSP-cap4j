package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.check_in.events.CheckedInDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * CheckIn.CheckedInDomainEvent领域事件订阅
 * 已签到
 */
@Service
@RequiredArgsConstructor
public class CheckedInDomainEventSubscriber {

    @EventListener(CheckedInDomainEvent.class)
    public void on(CheckedInDomainEvent event) {
        
    }

}
