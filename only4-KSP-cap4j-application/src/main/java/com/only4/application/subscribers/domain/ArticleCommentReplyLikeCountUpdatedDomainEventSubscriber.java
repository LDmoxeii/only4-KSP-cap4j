package com.only4.application.subscribers.domain;

import com.only4.domain.aggregates.article_comment_reply.events.ArticleCommentReplyLikeCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * ArticleCommentReply.ArticleCommentReplyLikeCountUpdatedDomainEvent领域事件订阅
 * 文章评论点赞数已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyLikeCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyLikeCountUpdatedDomainEvent.class)
    public void on(ArticleCommentReplyLikeCountUpdatedDomainEvent event) {
        
    }

}
