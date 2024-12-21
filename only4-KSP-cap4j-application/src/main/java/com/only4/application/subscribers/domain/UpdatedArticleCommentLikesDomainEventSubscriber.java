package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.UpdatedArticleCommentLikesDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.UpdatedArticleCommentLikesDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UpdatedArticleCommentLikesDomainEventSubscriber {

    @EventListener(UpdatedArticleCommentLikesDomainEvent.class)
    public void on(UpdatedArticleCommentLikesDomainEvent event) {
        
    }

}
