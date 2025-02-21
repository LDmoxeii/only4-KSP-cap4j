package com.only4.application.subscribers.domain;

import com.only4.application.commands.tag.UpdateTagRefCountCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.events.ArticleTagsUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Article.ArticleTagsUpdatedDomainEvent领域事件订阅<br/>
 * 文章标签更新事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleTagsUpdatedDomainEventSubscriber {

    @EventListener(ArticleTagsUpdatedDomainEvent.class)
    public void updateTagRefCount(ArticleTagsUpdatedDomainEvent event) {
        Article article = event.getEntity();
        List<Long> removeIds = event.getRemoveIds();
        List<Long> addIds = event.getAddIds();

        removeIds.forEach(tagId -> Optional.of(UpdateTagRefCountCmd.Request.builder()
                .tagId(tagId)
                .refCount(-1)
                .build()).ifPresent(Mediator.commands()::send)
        );

        addIds.forEach(tagId -> Optional.of(UpdateTagRefCountCmd.Request.builder()
                .tagId(tagId)
                .refCount(1)
                .build()).ifPresent(Mediator.commands()::send)
        );

    }

}
