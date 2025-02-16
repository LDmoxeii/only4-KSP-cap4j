package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleTagsUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleTagsUpdatedDomainEvent领域事件订阅<br/>
 * 文章标签更新事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleTagsUpdatedDomainEventSubscriber {

    @EventListener(ArticleTagsUpdatedDomainEvent.class)
    public void on(ArticleTagsUpdatedDomainEvent event) {

    }

}
