package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleLikeCountCmd;
import com.only4.domain.aggregates.article_like.ArticleLike;
import com.only4.domain.aggregates.article_like.events.ArticleUnlikedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ArticleLike.ArticleUnlikedDomainEvent领域事件订阅
 * 已取消点赞文章
 */
@Service
@RequiredArgsConstructor
public class ArticleUnlikedDomainEventSubscriber {

    @EventListener(ArticleUnlikedDomainEvent.class)
    public void updateArticleLikeCount(ArticleUnlikedDomainEvent event) {
        ArticleLike record = event.getEntity();

        Optional.of(UpdateArticleLikeCountCmd.Request.builder()
                        .articleId(record.getArticleId())
                        .likeCount(-1)
                        .build())
                .ifPresent(Mediator.commands()::send);
    }

}
