package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment.events.StarCommentDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarComment.StarCommentDeletedDomainEvent领域事件订阅
 * 星球评论已删除
 */
@Service
@RequiredArgsConstructor
public class StarCommentDeletedDomainEventSubscriber {

    @EventListener(StarCommentDeletedDomainEvent.class)
    public void updateStarCommentCount(StarCommentDeletedDomainEvent event) {
        //TODO: 更新星球评论数
    }

}
