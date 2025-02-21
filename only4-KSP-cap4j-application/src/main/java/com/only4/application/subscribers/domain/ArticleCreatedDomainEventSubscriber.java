package com.only4.application.subscribers.domain;

import com.only4.application.commands.member.UpdateMemberWorkCountCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.events.ArticleCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        article.getArticleAuthors().forEach(author ->
                Optional.of(UpdateMemberWorkCountCmd.Request.builder()
                                .memberId(author.getId())
                                .workCount(1)
                                .build())
                        .ifPresent(Mediator.commands()::send));
    }

}
