package com.only4.application.subscribers.domain;

import com.only4.application.commands.article.UpdateArticleCategoryInfoCmd;
import com.only4.application.queries.article.GetArticlesByCategoryIdQry;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.category.events.CategoryInfoUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.netcorepal.cap4j.ddd.Mediator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        List<Article> articles = Mediator.queries().send(GetArticlesByCategoryIdQry.Request.builder()
                .categoryId(category.getId())
                .build()).getArticles();

        articles.forEach(article -> Optional.of(
                        UpdateArticleCategoryInfoCmd.Request.builder()
                                .articleId(article.getId())
                                .categoryId(category.getId())
                                .categoryName(category.getName())
                                .build())
                .ifPresent(Mediator.commands()::send));
    }

}
