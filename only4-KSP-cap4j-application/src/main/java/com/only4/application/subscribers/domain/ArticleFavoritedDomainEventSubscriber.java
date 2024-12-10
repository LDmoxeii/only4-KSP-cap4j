package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.favorite_article.events.ArticleFavoritedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * FavoriteArticle.ArticleFavoritedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleFavoritedDomainEventSubscriber {

    @EventListener(ArticleFavoritedDomainEvent.class)
    public void on(ArticleFavoritedDomainEvent event) {
        
    }

}
