package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment_reply.events.ArticleCommentReplyDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentReply.ArticleCommentReplyDeletedDomainEvent领域事件订阅
 * 文章评论回复已删除
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyDeletedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyDeletedDomainEvent.class)
    public void on(ArticleCommentReplyDeletedDomainEvent event) {
        
    }

}
