package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_like.events.ArticleLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleLike.ArticleLikedDomainEvent领域事件订阅
 * 已点赞文章
 */
@Service
@RequiredArgsConstructor
public class ArticleLikedDomainEventSubscriber {

    @EventListener(ArticleLikedDomainEvent.class)
    public void on(ArticleLikedDomainEvent event) {
        
    }

}
