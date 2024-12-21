package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.UnlikedArticleDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.UnlikedArticleDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UnlikedArticleDomainEventSubscriber {

    @EventListener(UnlikedArticleDomainEvent.class)
    public void on(UnlikedArticleDomainEvent event) {
        
    }

}
