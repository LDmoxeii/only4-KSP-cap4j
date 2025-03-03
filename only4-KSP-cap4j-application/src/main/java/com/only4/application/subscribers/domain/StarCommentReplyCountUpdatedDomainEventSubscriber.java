package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment.events.StarCommentReplyCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarComment.StarCommentReplyCountUpdatedDomainEvent领域事件订阅
 * 星球回复数已更新
 */
@Service
@RequiredArgsConstructor
public class StarCommentReplyCountUpdatedDomainEventSubscriber {

    @EventListener(StarCommentReplyCountUpdatedDomainEvent.class)
    public void updateStarCommentCount(StarCommentReplyCountUpdatedDomainEvent event) {
        //TODO: 更新星球评论数
    }

}
