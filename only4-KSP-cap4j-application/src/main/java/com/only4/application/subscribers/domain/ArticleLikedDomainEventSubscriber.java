package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCommentLikeCountCmd;
import com.only4.application.commands.article.UpdateArticleLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleLikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleLikedDomainEventSubscriber {

    @EventListener(ArticleLikedDomainEvent.class)
    public void updateArticleLikeCount(ArticleLikedDomainEvent event) {
        Optional.of(event.getEntity()).map(article -> UpdateArticleLikeCountCmd.Request.builder()
                .articleId(article.getId())
                .likeCount(article.getArticleStatistics().getLikeCount() + 1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
