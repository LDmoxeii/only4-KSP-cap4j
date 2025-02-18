package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentCountCmd;
import com.only4.application.commands.article.UpdateArticleCommentReplyCountCmd;
import com.only4.domain.aggregates.article.events.ArticleCommentReplyDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleCommentReplyDeletedDomainEvent领域事件订阅
 * 文章评论回复已删除
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyDeletedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyDeletedDomainEvent.class)
    public void updateArticleCommentCount(ArticleCommentReplyDeletedDomainEvent event) {
        val article = event.getEntity();
        Optional.of(UpdateArticleCommentCountCmd.Request.builder()
                        .articleId(article.getId())
                        .commentCount(1)
                        .build())
                .ifPresent(Mediator.commands()::send);
    }

    @EventListener(ArticleCommentReplyDeletedDomainEvent.class)
    public void updateArticleCommentReplyCount(ArticleCommentReplyDeletedDomainEvent event) {
        val article = event.getEntity();
        val commentId = event.getCommentId();
        Optional.of(UpdateArticleCommentReplyCountCmd.Request.builder()
                        .articleId(article.getId())
                        .commentId(commentId)
                        .replyCount(1)
                        .build())
                .ifPresent(Mediator.commands()::send);
    }
}
