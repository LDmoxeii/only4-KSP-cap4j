package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCategoryInfoBatchCmd;
import com.only4.application.queries.article.GetArticlesByCategoryIdQry;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.category.events.CategoryInfoUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Category.CategoryInfoUpdatedDomainEvent领域事件订阅
 * 分类信息已更新
 */
@Service
@RequiredArgsConstructor
public class CategoryInfoUpdatedDomainEventSubscriber {

    @EventListener(CategoryInfoUpdatedDomainEvent.class)
    public void updateArticleCategoryInfo(CategoryInfoUpdatedDomainEvent event) {
        Category category = event.getEntity();

        Set<Long> ids = Mediator.queries().send(GetArticlesByCategoryIdQry.Request.builder()
                        .categoryId(category.getId())
                        .build()).getArticles()
                .stream()
                .map(Article::getId)
                .collect(Collectors.toSet());

        Optional.of(UpdateArticleCategoryInfoBatchCmd.Request.builder()
                .articleIds(ids)
                .categoryId(category.getId())
                .categoryName(category.getName())
                .build()).ifPresent(Mediator.commands()::send);
    }

}
