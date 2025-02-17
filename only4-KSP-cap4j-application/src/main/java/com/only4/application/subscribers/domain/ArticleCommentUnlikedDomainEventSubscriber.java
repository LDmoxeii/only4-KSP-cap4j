package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleCommentUnlikedDomainEvent领域事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentUnlikedDomainEventSubscriber {

    @EventListener(ArticleCommentUnlikedDomainEvent.class)
    public void updateArticleCommentLikeCount(ArticleCommentUnlikedDomainEvent event) {
        val article = event.getEntity();
        val commentId = event.getCommentId();

        Optional.of(UpdateArticleCommentLikeCountCmd.Request.builder()
                .articleId(article.getId())
                .commentId(commentId)
                .likeCount(-1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
