package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_like.events.ArticleUnLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleLike.ArticleUnLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleUnLikedDomainEventSubscriber {

    @EventListener(ArticleUnLikedDomainEvent.class)
    public void on(ArticleUnLikedDomainEvent event) {
        
    }

}
