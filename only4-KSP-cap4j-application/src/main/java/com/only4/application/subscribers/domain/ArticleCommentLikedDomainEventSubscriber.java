package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment_like.events.ArticleCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentLike.ArticleCommentLikedDomainEvent领域事件订阅
 * 已点赞文章评论
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikedDomainEventSubscriber {

    @EventListener(ArticleCommentLikedDomainEvent.class)
    public void on(ArticleCommentLikedDomainEvent event) {
        
    }

}
