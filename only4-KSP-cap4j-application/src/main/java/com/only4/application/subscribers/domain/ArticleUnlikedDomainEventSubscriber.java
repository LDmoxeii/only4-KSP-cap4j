package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleLikeCountCmd;
import com.only4.domain.aggregates.article.events.ArticleUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleUnlikedDomainEvent领域事件订阅
 * todo: 领域事件说明
 */
@Service
@RequiredArgsConstructor
public class ArticleUnlikedDomainEventSubscriber {

    @EventListener(ArticleUnlikedDomainEvent.class)
    public void updateArticleLikeCount(ArticleUnlikedDomainEvent event) {
        Optional.of(event.getEntity())
                .map(article -> UpdateArticleLikeCountCmd.Request.builder()
                        .articleId(article.getId())
                        .likeCount(article.getArticleStatistics().getLikeCount() - 1)
                        .build()
                )
                .ifPresent(Mediator.commands()::send);
    }

}
