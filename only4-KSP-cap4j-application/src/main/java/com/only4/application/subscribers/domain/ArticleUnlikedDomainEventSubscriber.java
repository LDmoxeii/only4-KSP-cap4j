package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleUnlikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleUnlikedDomainEventSubscriber {

    @EventListener(ArticleUnlikedDomainEvent.class)
    public void on(ArticleUnlikedDomainEvent event) {
        
    }

}
