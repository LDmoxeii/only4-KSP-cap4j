package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleLikedDomainEventSubscriber {

    @EventListener(ArticleLikedDomainEvent.class)
    public void on(ArticleLikedDomainEvent event) {
        
    }

}
