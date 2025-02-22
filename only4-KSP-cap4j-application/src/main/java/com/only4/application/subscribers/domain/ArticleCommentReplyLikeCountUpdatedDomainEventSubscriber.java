package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberLikeCountCmd;
import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import com.only4.domain.aggregates.article_comment_reply.events.ArticleCommentReplyLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleCommentReply.ArticleCommentReplyLikeCountUpdatedDomainEvent领域事件订阅
 * 文章评论点赞数已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyLikeCountUpdatedDomainEvent.class)
    public void updateMemberLikeCount(ArticleCommentReplyLikeCountUpdatedDomainEvent event) {
        ArticleCommentReply reply = event.getEntity();
        Integer likeCount = event.getLikeCount();

        Optional.of(UpdateMemberLikeCountCmd.Request.builder()
                .memberId(reply.getAuthorId())
                .likeCount(likeCount)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
