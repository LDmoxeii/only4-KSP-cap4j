package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment.events.StarCommentCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarComment.StarCommentCreatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class StarCommentCreatedDomainEventSubscriber {

    @EventListener(StarCommentCreatedDomainEvent.class)
    public void on(StarCommentCreatedDomainEvent event) {
        
    }

}
