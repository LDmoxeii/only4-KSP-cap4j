package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment.events.StarCommentDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarComment.StarCommentDeletedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class StarCommentDeletedDomainEventSubscriber {

    @EventListener(StarCommentDeletedDomainEvent.class)
    public void on(StarCommentDeletedDomainEvent event) {
        
    }

}
