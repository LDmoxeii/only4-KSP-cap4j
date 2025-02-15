package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star.events.StarCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Star.StarCommentLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class StarCommentLikedDomainEventSubscriber {

    @EventListener(StarCommentLikedDomainEvent.class)
    public void on(StarCommentLikedDomainEvent event) {
        
    }

}
