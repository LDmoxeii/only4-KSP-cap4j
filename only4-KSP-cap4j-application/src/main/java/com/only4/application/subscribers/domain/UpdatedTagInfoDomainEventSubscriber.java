package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleTagInfoCmd;
import com.only4.application.queries.article.GetArticlesByTagIdQry;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.tag.Tag;
import com.only4.domain.aggregates.tag.events.UpdatedTagInfoDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Tag.UpdatedTagInfoDomainEvent领域事件订阅
 * 标签信息已更新
 */
@Service
@RequiredArgsConstructor
public class UpdatedTagInfoDomainEventSubscriber {

    @EventListener(UpdatedTagInfoDomainEvent.class)
    public void updateArticleTagInfo(UpdatedTagInfoDomainEvent event) {
        Tag tag = event.getEntity();

        List<Article> articles = Mediator.queries().send(GetArticlesByTagIdQry.Request.builder()
                .tagId(tag.getId())
                .build()).getArticles();

        articles.forEach(article ->
                Optional.of(UpdateArticleTagInfoCmd.Request.builder()
                                .articleId(article.getId())
                                .tagId(tag.getId())
                                .tagName(tag.getName())
                                .build())
                        .ifPresent(Mediator.commands()::send)
        );
    }

}
