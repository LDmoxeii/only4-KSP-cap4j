package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.CreatedArticleDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.CreatedArticleDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class CreatedArticleDomainEventSubscriber {

    @EventListener(CreatedArticleDomainEvent.class)
    public void on(CreatedArticleDomainEvent event) {
        
    }

}
