package com.only4.application.subscribers.domain;

import com.only4.application.commands.category.UpdateCategoryRefCountCmd;
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

        removeIds.forEach(categoryId -> Optional.of(UpdateCategoryRefCountCmd.Request.builder()
                .categoryId(categoryId)
                .refCount(-1)
                .build()).ifPresent(Mediator.commands()::send)
        );

        addIds.forEach(categoryId -> Optional.of(UpdateCategoryRefCountCmd.Request.builder()
                .categoryId(categoryId)
                .refCount(1)
                .build()).ifPresent(Mediator.commands()::send)
        );
    }

}
