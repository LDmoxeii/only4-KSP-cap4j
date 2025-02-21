package com.only4.application.subscribers.domain;

import com.only4.application.commands.article_comment.UpdateArticleCommentLikeCountCmd;
import com.only4.domain.aggregates.article_comment_like.ArticleCommentLike;
import com.only4.domain.aggregates.article_comment_like.events.ArticleCommentLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleCommentLike.ArticleCommentLikedDomainEvent领域事件订阅
 * 已点赞文章评论
 */
@Service
@RequiredArgsConstructor
public class ArticleCommentLikedDomainEventSubscriber {

    @EventListener(ArticleCommentLikedDomainEvent.class)
    public void updateArticleCommentLikeCount(ArticleCommentLikedDomainEvent event) {
        ArticleCommentLike record = event.getEntity();

        Optional.of(UpdateArticleCommentLikeCountCmd.Request.builder()
                        .commentId(record.getArticleCommentId())
                        .likeCount(1)
                        .build())
                .ifPresent(Mediator.commands()::send);
    }

}
