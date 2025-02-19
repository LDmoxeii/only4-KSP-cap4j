package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment_reply.events.ArticleCommentReplyCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentReply.ArticleCommentReplyCreatedDomainEvent领域事件订阅
 * 文章评论回复已创建
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyCreatedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyCreatedDomainEvent.class)
    public void on(ArticleCommentReplyCreatedDomainEvent event) {
        
    }

}
