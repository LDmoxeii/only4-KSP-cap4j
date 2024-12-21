package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.UnlikedArticleCommentDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.UnlikedArticleCommentDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UnlikedArticleCommentDomainEventSubscriber {

    @EventListener(UnlikedArticleCommentDomainEvent.class)
    public void on(UnlikedArticleCommentDomainEvent event) {
        
    }

}
