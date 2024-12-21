package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star.events.CreatedStarCommentDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Star.CreatedStarCommentDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CreatedStarCommentDomainEventSubscriber {

    @EventListener(CreatedStarCommentDomainEvent.class)
    public void on(CreatedStarCommentDomainEvent event) {
        
    }

}
