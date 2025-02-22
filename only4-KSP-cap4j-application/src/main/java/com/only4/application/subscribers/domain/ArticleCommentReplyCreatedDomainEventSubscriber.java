package com.only4.application.subscribers.domain;

import com.only4.application.commands.article_comment.UpdateArticleCommentReplyCountCmd;
import com.only4.domain.aggregates.article_comment_reply.ArticleCommentReply;
import com.only4.domain.aggregates.article_comment_reply.events.ArticleCommentReplyCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleCommentReply.ArticleCommentReplyCreatedDomainEvent领域事件订阅
 * 文章评论回复已创建
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyCreatedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyCreatedDomainEvent.class)
    public void updateArticleCommentReplyCount(ArticleCommentReplyCreatedDomainEvent event) {
        ArticleCommentReply reply = event.getEntity();

        Optional.of(UpdateArticleCommentReplyCountCmd.Request.builder()
                .commentId(reply.getArticleCommentId())
                .replyCount(1)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
