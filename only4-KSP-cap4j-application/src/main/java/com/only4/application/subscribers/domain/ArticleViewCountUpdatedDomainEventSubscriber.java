package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleViewCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleViewCountUpdatedDomainEvent领域事件订阅
 * 文章播放量已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleViewCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleViewCountUpdatedDomainEvent.class)
    public void on(ArticleViewCountUpdatedDomainEvent event) {
        
    }

}
