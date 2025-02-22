package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleTagInfoBatchCmd;
import com.only4.application.queries.article.GetArticlesByTagIdQry;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.tag.Tag;
import com.only4.domain.aggregates.tag.events.TagInfoUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Tag.TagInfoUpdatedDomainEvent领域事件订阅
 * 标签信息已更新
 */
@Service
@RequiredArgsConstructor
public class TagInfoUpdatedDomainEventSubscriber {

    @EventListener(TagInfoUpdatedDomainEvent.class)
    public void updateArticleTagInfo(TagInfoUpdatedDomainEvent event) {
        Tag tag = event.getEntity();

        Set<Long> ids = Mediator.queries().send(GetArticlesByTagIdQry.Request.builder()
                        .tagId(tag.getId())
                        .build()).getArticles().stream()
                .map(Article::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateArticleTagInfoBatchCmd.Request.builder()
                .articleIds(ids)
                .tagId(tag.getId())
                .tagName(tag.getName())
                .build()).ifPresent(Mediator.commands()::send);
    }

}
