package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.LikesUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.LikesUpdatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class LikesUpdatedDomainEventSubscriber {

    @EventListener(LikesUpdatedDomainEvent.class)
    public void on(LikesUpdatedDomainEvent event) {
        
    }

}
