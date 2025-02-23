package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment.events.StarCommentCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarComment.StarCommentCreatedDomainEvent领域事件订阅
 * 星球评论已创建
 */
@Service
@RequiredArgsConstructor
public class StarCommentCreatedDomainEventSubscriber {

    @EventListener(StarCommentCreatedDomainEvent.class)
    public void updateStarCommentCount(StarCommentCreatedDomainEvent event) {
        //TODO: 更新星球评论数
    }

}
