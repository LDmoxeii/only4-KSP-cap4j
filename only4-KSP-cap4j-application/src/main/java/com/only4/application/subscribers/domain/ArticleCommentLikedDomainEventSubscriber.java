package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Article.ArticleCommentLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikedDomainEventSubscriber {

    @EventListener(ArticleCommentLikedDomainEvent.class)
    public void updateArticleCommentLikeCount(ArticleCommentLikedDomainEvent event) {
        val article = event.getEntity();
        val commentId = event.getCommentId();
        article.getArticleComments().stream()
                .filter(c -> Objects.equals(c.getId(), commentId))
                .findFirst()
                .map(articleComment -> UpdateArticleCommentLikeCountCmd.Request.builder()
                        .articleId(article.getId())
                        .commentId(commentId)
                        .likeCount(articleComment.getArticleCommentStatistics().getLikeCount() + 1)
                        .build()
                )
                .ifPresent(Mediator.commands()::send);
    }

}
