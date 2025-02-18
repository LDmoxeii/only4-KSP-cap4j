package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleUnlikedDomainEvent领域事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleUnlikedDomainEventSubscriber {

    @EventListener(ArticleUnlikedDomainEvent.class)
    public void updateArticleLikeCount(ArticleUnlikedDomainEvent event) {
        val article = event.getEntity();

        Optional.ofNullable(UpdateArticleLikeCountCmd.Request.builder()
                .articleId(article.getId())
                .likeCount(-1)
                .build())
                .ifPresent(Mediator.commands()::send);
    }

}
