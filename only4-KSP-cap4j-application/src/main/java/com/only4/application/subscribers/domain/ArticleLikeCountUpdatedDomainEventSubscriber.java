package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleLikeCountUpdatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleLikeCountUpdatedDomainEvent.class)
    public void on(ArticleLikeCountUpdatedDomainEvent event) {
        
    }

}
