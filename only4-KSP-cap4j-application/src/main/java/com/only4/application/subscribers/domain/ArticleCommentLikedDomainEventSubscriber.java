package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleCommentLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikedDomainEventSubscriber {

    @EventListener(ArticleCommentLikedDomainEvent.class)
    public void on(ArticleCommentLikedDomainEvent event) {
        
    }

}
