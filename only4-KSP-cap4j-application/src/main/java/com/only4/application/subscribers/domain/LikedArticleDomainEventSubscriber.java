package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.LikedArticleDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.LikedArticleDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class LikedArticleDomainEventSubscriber {

    @EventListener(LikedArticleDomainEvent.class)
    public void on(LikedArticleDomainEvent event) {
        
    }

}
