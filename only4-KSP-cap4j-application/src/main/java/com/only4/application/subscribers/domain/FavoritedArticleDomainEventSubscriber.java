package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.member.events.FavoritedArticleDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Member.FavoritedArticleDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class FavoritedArticleDomainEventSubscriber {

    @EventListener(FavoritedArticleDomainEvent.class)
    public void on(FavoritedArticleDomainEvent event) {
        
    }

}
