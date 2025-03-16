package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.star_like.events.StarLikeDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * StarLike.StarLikeDomainEvent领域事件订阅
 * StarUnliked
 */
@Service
@RequiredArgsConstructor
public class StarLikeDomainEventSubscriber {

    @EventListener(StarLikeDomainEvent.class)
    public void on(StarLikeDomainEvent event) {
        
    }

}
