package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentCountCmd;
import com.only4.application.commands.article.UpdateArticleCommentReplyCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleCommentCreatedDomainEvent领域事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentCreatedDomainEventSubscriber {

    @EventListener(ArticleCommentCreatedDomainEvent.class)
    public void updateArticleCommentCount(ArticleCommentCreatedDomainEvent event) {
        val article = event.getEntity();
        Optional.of(UpdateArticleCommentCountCmd.Request.builder()
                .articleId(article.getId())
                .commentCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

    @EventListener(ArticleCommentCreatedDomainEvent.class)
    public void updateArticleCommentReplyCount(ArticleCommentCreatedDomainEvent event) {
        val article = event.getEntity();
        val comment = event.getComment();
        Optional.of(UpdateArticleCommentReplyCountCmd.Request.builder()
                .articleId(article.getId())
                .commentId(comment.getParentId())
                .replyCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
