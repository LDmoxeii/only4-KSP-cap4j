package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentCountCmd;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.events.ArticleCommentDeletedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleComment.ArticleCommentDeletedDomainEvent领域事件订阅
 * 文章评论已删除
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentDeletedDomainEventSubscriber {

    @EventListener(ArticleCommentDeletedDomainEvent.class)
    public void updateArticleCommentCount(ArticleCommentDeletedDomainEvent event) {
        ArticleComment comment = event.getEntity();

        Optional.of(UpdateArticleCommentCountCmd.Request.builder()
                .articleId(comment.getArticleId())
                .commentCount(-1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
