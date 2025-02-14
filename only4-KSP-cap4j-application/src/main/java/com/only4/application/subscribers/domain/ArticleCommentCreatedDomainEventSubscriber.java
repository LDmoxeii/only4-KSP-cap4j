package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleCommentCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleCommentCreatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentCreatedDomainEventSubscriber {

    @EventListener(ArticleCommentCreatedDomainEvent.class)
    public void on(ArticleCommentCreatedDomainEvent event) {
        
    }

}
