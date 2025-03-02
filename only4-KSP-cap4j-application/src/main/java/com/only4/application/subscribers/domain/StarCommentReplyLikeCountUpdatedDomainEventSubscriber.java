package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberLikeCountCmd;
import com.only4.domain.aggregates.star_comment_reply.StarCommentReply;
import com.only4.domain.aggregates.star_comment_reply.events.StarCommentReplyLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * StarCommentReply.StarCommentReplyLikeCountUpdatedDomainEvent领域事件订阅
 * 星球评论回复点赞数已更新
 */
@Service
@RequiredArgsConstructor
public class StarCommentReplyLikeCountUpdatedDomainEventSubscriber {

    @EventListener(StarCommentReplyLikeCountUpdatedDomainEvent.class)
    public void updateMemberLikeCount(StarCommentReplyLikeCountUpdatedDomainEvent event) {
        StarCommentReply reply = event.getEntity();
        Integer likeCount = event.getLikeCount();

        Optional.of(UpdateMemberLikeCountCmd.Request.builder()
            .memberId(reply.getAuthorId())
            .likeCount(likeCount)
            .build()).ifPresent(Mediator.commands()::send);

    }

}
