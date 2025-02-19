package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment.events.ArticleCommentLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleComment.ArticleCommentLikeCountUpdatedDomainEvent领域事件订阅
 * 文章评论点赞数已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleCommentLikeCountUpdatedDomainEvent.class)
    public void on(ArticleCommentLikeCountUpdatedDomainEvent event) {
        
    }

}
