package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment.events.ArticleCommentDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleComment.ArticleCommentDeletedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentDeletedDomainEventSubscriber {

    @EventListener(ArticleCommentDeletedDomainEvent.class)
    public void on(ArticleCommentDeletedDomainEvent event) {
        
    }

}
