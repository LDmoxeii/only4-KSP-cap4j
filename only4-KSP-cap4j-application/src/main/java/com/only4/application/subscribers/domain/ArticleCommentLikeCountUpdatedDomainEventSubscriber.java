package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article.events.ArticleCommentLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Article.ArticleCommentLikeCountUpdatedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleCommentLikeCountUpdatedDomainEvent.class)
    public void on(ArticleCommentLikeCountUpdatedDomainEvent event) {
        
    }

}
