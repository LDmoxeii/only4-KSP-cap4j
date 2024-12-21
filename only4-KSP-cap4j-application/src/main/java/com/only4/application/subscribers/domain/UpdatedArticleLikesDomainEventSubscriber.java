package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.UpdatedArticleLikesDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.UpdatedArticleLikesDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class UpdatedArticleLikesDomainEventSubscriber {

    @EventListener(UpdatedArticleLikesDomainEvent.class)
    public void on(UpdatedArticleLikesDomainEvent event) {
        
    }

}
