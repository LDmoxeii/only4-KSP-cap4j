package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleLikeCountCmd;
import com.only4.domain.aggregates.article_like.ArticleLike;
import com.only4.domain.aggregates.article_like.events.ArticleLikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleLike.ArticleLikedDomainEvent领域事件订阅
 * 已点赞文章
 */
@Service
@RequiredArgsConstructor
public class ArticleLikedDomainEventSubscriber {

    @EventListener(ArticleLikedDomainEvent.class)
    public void updateArticleLikeCount(ArticleLikedDomainEvent event) {
        ArticleLike record = event.getEntity();

        Optional.of(UpdateArticleLikeCountCmd.Request.builder()
                        .articleId(record.getArticleId())
                        .likeCount(1)
                        .build())
                .ifPresent(Mediator.commands()::send);
    }

}
