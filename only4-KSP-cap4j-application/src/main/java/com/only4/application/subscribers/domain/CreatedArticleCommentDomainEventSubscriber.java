package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.CreatedArticleCommentDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.CreatedArticleCommentDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CreatedArticleCommentDomainEventSubscriber {

    @EventListener(CreatedArticleCommentDomainEvent.class)
    public void on(CreatedArticleCommentDomainEvent event) {
        
    }

}
