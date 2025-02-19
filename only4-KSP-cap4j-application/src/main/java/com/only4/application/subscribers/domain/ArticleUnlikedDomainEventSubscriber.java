package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_like.events.ArticleUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleLike.ArticleUnlikedDomainEvent领域事件订阅
 * 已取消点赞文章
 */
@Service
@RequiredArgsConstructor
public class ArticleUnlikedDomainEventSubscriber {

    @EventListener(ArticleUnlikedDomainEvent.class)
    public void on(ArticleUnlikedDomainEvent event) {
        
    }

}
