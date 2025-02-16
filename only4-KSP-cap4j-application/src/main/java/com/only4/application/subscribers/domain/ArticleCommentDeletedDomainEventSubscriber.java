package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentCountCmd;
import com.only4.application.commands.article.UpdateArticleCommentReplyCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleCommentDeletedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentDeletedDomainEventSubscriber {

    @EventListener(ArticleCommentDeletedDomainEvent.class)
    public void updateArticleCommentCount(ArticleCommentDeletedDomainEvent event) {
        val article = event.getEntity();
        Optional.of(UpdateArticleCommentCountCmd.Request.builder()
                .articleId(article.getId())
                .commentCount(article.getArticleStatistics().getCommentCount())
                .build())
                .ifPresent(Mediator.commands()::send);
    }

    @EventListener(ArticleCommentDeletedDomainEvent.class)
    public void updateArticleCommentReplyCount(ArticleCommentDeletedDomainEvent event) {
        val article = event.getEntity();
        val commentId = event.getCommentId();
        if (commentId <= 0) return;
        article.getArticleComments().stream()
                .filter(c -> c.getId().equals(commentId))
                .findFirst()
                .map(articleComment -> UpdateArticleCommentReplyCountCmd.Request.builder()
                        .articleId(article.getId())
                        .commentId(commentId)
                        .replyCount(articleComment.getArticleCommentStatistics().getReplyCount() + 1)
                        .build()
                )
                .ifPresent(Mediator.commands()::send);
    }

}
