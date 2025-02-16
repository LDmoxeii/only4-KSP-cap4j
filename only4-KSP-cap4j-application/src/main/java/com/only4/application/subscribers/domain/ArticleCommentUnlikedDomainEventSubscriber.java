package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Article.ArticleCommentUnlikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentUnlikedDomainEventSubscriber {

    @EventListener(ArticleCommentUnlikedDomainEvent.class)
    public void updateArticleCommentLikeCount(ArticleCommentUnlikedDomainEvent event) {
        val article = event.getEntity();
        val commentId = event.getCommentId();
        article.getArticleComments().stream()
                .filter(c -> Objects.equals(c.getId(), commentId))
                .findFirst()
                .map(articleComment -> UpdateArticleCommentLikeCountCmd.Request.builder()
                        .articleId(article.getId())
                        .commentId(commentId)
                        .build()
                )
                .ifPresent(Mediator.commands()::send);
    }

}
