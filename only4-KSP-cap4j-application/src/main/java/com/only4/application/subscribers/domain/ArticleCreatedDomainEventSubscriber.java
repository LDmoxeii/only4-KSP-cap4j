package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberWorkCountBatchCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.events.ArticleCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Article.ArticleCreatedDomainEvent领域事件订阅
 * 文章已创建
 */
@Service
@RequiredArgsConstructor
public class ArticleCreatedDomainEventSubscriber {

    @EventListener(ArticleCreatedDomainEvent.class)
    public void updateMemberWorkCount(ArticleCreatedDomainEvent event) {
        Article article = event.getEntity();

        Set<Long> ids = article.getArticleAuthors()
                .stream().map(ArticleAuthor::getAuthorId)
                .collect(Collectors.toSet());

        Optional.of(UpdateMemberWorkCountBatchCmd.Request.builder()
                .memberIds(ids)
                .workCount(1)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
