package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.favorite_article.events.ArticleUnfavoritedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * FavoriteArticle.ArticleUnfavoritedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleUnfavoritedDomainEventSubscriber {

    @EventListener(ArticleUnfavoritedDomainEvent.class)
    public void on(ArticleUnfavoritedDomainEvent event) {
        
    }

}
