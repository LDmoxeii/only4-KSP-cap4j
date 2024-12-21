package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.tag.events.UpdatedTagInfoDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Tag.UpdatedTagInfoDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UpdatedTagInfoDomainEventSubscriber {

    @EventListener(UpdatedTagInfoDomainEvent.class)
    public void on(UpdatedTagInfoDomainEvent event) {
        
    }

}
