package com.only4.application.subscribers.domain;

import com.only4.application.commands.star_comment_reply.UpdateStarCommentReplyReportCountCmd;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.events.StarCommentReplyCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarCommentReply.StarCommentReplyCreatedDomainEvent领域事件订阅
 * 星球评论回复已创建
 */
@Service
@RequiredArgsConstructor
public class StarCommentReplyCreatedDomainEventSubscriber {

    @EventListener(StarCommentReplyCreatedDomainEvent.class)
    public void updateStarCommentReplyCount(StarCommentReplyCreatedDomainEvent event) {
        StarCommentReply reply = event.getEntity();

    //TODO: UpdateStarCommentReplyCountCmd

    }

}
