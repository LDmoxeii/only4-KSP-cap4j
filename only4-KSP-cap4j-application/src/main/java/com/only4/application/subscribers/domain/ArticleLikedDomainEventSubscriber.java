package com.only4.application.subscribers.domain;

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
 */
@Service
@RequiredArgsConstructor
public class ArticleLikedDomainEventSubscriber {

    @EventListener(ArticleLikedDomainEvent.class)
    public void updateArticleLikeCount(ArticleLikedDomainEvent event) {
        val article = event.getEntity();

        Optional.of(UpdateArticleLikeCountCmd.Request.builder()
                .articleId(article.getId())
                .likeCount(1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
