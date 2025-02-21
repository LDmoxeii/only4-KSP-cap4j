package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberViewCountCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.events.ArticleViewCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Article.ArticleViewCountUpdatedDomainEvent领域事件订阅
 * 文章播放量已更新
 */
@Service
@RequiredArgsConstructor
public class ArticleViewCountUpdatedDomainEventSubscriber {

    @EventListener(ArticleViewCountUpdatedDomainEvent.class)
    public void updateMemberViewCount(ArticleViewCountUpdatedDomainEvent event) {
        Article article = event.getEntity();
        Integer viewCount = event.getViewCount();

        article.getArticleAuthors().forEach(author ->
                Optional.of(UpdateMemberViewCountCmd.Request.builder()
                        .memberId(author.getAuthorId())
                        .viewCount(viewCount)
                        .build()).ifPresent(Mediator.commands()::send)
        );
    }

}
