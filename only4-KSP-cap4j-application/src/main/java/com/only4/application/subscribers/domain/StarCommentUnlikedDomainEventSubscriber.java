package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment_like.events.StarCommentUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarCommentLike.StarCommentUnlikedDomainEvent领域事件订阅
 * 已取消点赞星球评论
 */
@Service
@RequiredArgsConstructor
public class StarCommentUnlikedDomainEventSubscriber {

    @EventListener(StarCommentUnlikedDomainEvent.class)
    public void on(StarCommentUnlikedDomainEvent event) {
        
    }

}
