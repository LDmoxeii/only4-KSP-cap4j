package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment_like.events.ArticleCommentUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentLike.ArticleCommentUnlikedDomainEvent领域事件订阅
 * 已取消点赞文章评论
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentUnlikedDomainEventSubscriber {

    @EventListener(ArticleCommentUnlikedDomainEvent.class)
    public void on(ArticleCommentUnlikedDomainEvent event) {
        
    }

}
