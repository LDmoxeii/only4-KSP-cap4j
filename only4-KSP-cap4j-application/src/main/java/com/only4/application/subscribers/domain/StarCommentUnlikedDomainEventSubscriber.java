package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star.events.StarCommentUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Star.StarCommentUnlikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class StarCommentUnlikedDomainEventSubscriber {

    @EventListener(StarCommentUnlikedDomainEvent.class)
    public void on(StarCommentUnlikedDomainEvent event) {
        
    }

}
