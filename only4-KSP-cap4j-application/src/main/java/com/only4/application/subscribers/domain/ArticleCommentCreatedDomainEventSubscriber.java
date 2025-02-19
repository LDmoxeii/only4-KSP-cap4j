package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment.events.ArticleCommentCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleComment.ArticleCommentCreatedDomainEvent领域事件订阅
 * 文章评论已更创建
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentCreatedDomainEventSubscriber {

    @EventListener(ArticleCommentCreatedDomainEvent.class)
    public void on(ArticleCommentCreatedDomainEvent event) {
        
    }

}
