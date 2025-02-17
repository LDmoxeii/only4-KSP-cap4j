package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleCommentLikedDomainEvent领域事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikedDomainEventSubscriber {

    @EventListener(ArticleCommentLikedDomainEvent.class)
    public void updateArticleCommentLikeCount(ArticleCommentLikedDomainEvent event) {
        val article = event.getEntity();
        val comment = event.getComment();

        Optional.of(UpdateArticleCommentLikeCountCmd.Request.builder()
                .articleId(article.getId())
                .commentId(comment.getId())
                .likeCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
