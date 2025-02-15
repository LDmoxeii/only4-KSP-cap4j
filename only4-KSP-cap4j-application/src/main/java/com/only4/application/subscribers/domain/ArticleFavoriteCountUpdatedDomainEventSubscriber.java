package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleFavoriteCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleFavoriteCountUpdatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleFavoriteCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleFavoriteCountUpdatedDomainEvent.class)
    public void on(ArticleFavoriteCountUpdatedDomainEvent event) {
        
    }

}
