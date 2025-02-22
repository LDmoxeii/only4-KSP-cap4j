package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberViewCountBatchCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.events.ArticleViewCountUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

        Set<Long> ids = article.getArticleAuthors().stream()
                .map(ArticleAuthor::getAuthorId)
                .collect(Collectors.toSet());

        Optional.of(UpdateMemberViewCountBatchCmd.Request.builder()
                .memberIds(ids)
                .viewCount(viewCount)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
