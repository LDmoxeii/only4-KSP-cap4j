package com.only4.application.subscribers.domain;

import com.only4.application.commands.tag.UpdateTagRefCountBatchCmd;
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

        Optional.of(UpdateTagRefCountBatchCmd.Request.builder()
                .tagIds(removeIds)
                .refCount(-1)
                .build()).ifPresent(Mediator.commands()::send);

        Optional.of(UpdateTagRefCountBatchCmd.Request.builder()
                .tagIds(addIds)
                .refCount(1)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
