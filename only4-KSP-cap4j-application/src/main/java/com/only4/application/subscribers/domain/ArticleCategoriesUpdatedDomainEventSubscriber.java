package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleCategoriesUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleCategoriesUpdatedDomainEvent领域事件订阅<br/>
 * 文章分类更新事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleCategoriesUpdatedDomainEventSubscriber {

    @EventListener(ArticleCategoriesUpdatedDomainEvent.class)
    public void on(ArticleCategoriesUpdatedDomainEvent event) {

    }

}
