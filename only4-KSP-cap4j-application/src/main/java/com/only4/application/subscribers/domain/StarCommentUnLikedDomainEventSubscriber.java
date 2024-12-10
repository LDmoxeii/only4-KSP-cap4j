package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment_like.events.StarCommentUnLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarCommentLike.StarCommentUnLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class StarCommentUnLikedDomainEventSubscriber {

    @EventListener(StarCommentUnLikedDomainEvent.class)
    public void on(StarCommentUnLikedDomainEvent event) {
        
    }

}
