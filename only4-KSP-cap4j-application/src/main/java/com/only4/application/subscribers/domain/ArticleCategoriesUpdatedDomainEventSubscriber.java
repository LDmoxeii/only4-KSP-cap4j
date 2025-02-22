package com.only4.application.subscribers.domain;

import com.only4.application.commands.category.UpdateCategoryRefCountBatchCmd;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.events.ArticleCategoriesUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Article.ArticleCategoriesUpdatedDomainEvent领域事件订阅<br/>
 * 文章分类更新事件订阅
 */
@Service
@RequiredArgsConstructor
public class ArticleCategoriesUpdatedDomainEventSubscriber {

    @EventListener(ArticleCategoriesUpdatedDomainEvent.class)
    public void updateCategoryRefCount(ArticleCategoriesUpdatedDomainEvent event) {
        Article article = event.getEntity();
        List<Long> removeIds = event.getRemoveIds();
        List<Long> addIds = event.getAddIds();

        Optional.of(UpdateCategoryRefCountBatchCmd.Request.builder()
                .categoryIds(removeIds)
                .refCount(-1)
                .build()).ifPresent(Mediator.commands()::send);

        Optional.of(UpdateCategoryRefCountBatchCmd.Request.builder()
                .categoryIds(addIds)
                .refCount(1)
                .build()).ifPresent(Mediator.commands()::send);
    }

}
