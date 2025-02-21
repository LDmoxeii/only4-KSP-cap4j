package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentCountCmd;
import com.only4.domain.aggregates.article_comment.ArticleComment;
import com.only4.domain.aggregates.article_comment.events.ArticleCommentReplyCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleComment.ArticleCommentReplyCountUpdatedDomainEvent领域事件订阅
 * 文章评论回复数已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentReplyCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleCommentReplyCountUpdatedDomainEvent.class)
    public void updateArticleCommentCount(ArticleCommentReplyCountUpdatedDomainEvent event) {
        ArticleComment comment = event.getEntity();
        Integer replyCount = event.getReplyCount();

        Optional.of(UpdateArticleCommentCountCmd.Request.builder()
                .articleId(comment.getArticleId())
                .commentCount(replyCount)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
