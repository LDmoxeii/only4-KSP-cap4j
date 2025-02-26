package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.events.StarCommentReplyDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarCommentReply.StarCommentReplyDeletedDomainEvent领域事件订阅
 * 星球评论回复已删除
 */
@Service
@RequiredArgsConstructor
public class StarCommentReplyDeletedDomainEventSubscriber {

    @EventListener(StarCommentReplyDeletedDomainEvent.class)
    public void updateStarCommentReplyCount(StarCommentReplyDeletedDomainEvent event) {
        StarCommentReply reply = event.getEntity();
        //TODO: UpdateStarCommentReplyCount
    }

}
