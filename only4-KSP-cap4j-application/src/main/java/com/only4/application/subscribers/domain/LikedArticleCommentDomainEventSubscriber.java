package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.LikedArticleCommentDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.LikedArticleCommentDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class LikedArticleCommentDomainEventSubscriber {

    @EventListener(LikedArticleCommentDomainEvent.class)
    public void on(LikedArticleCommentDomainEvent event) {
        
    }

}
