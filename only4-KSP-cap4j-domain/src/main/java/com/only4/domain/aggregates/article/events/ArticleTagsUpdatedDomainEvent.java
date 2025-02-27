package com.only4.domain.aggregates.article.events;

import com.only4.domain.aggregates.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

import java.util.List;

/**
 * Article.ArticleTagsUpdatedDomainEvent领域事件<br/>
 * 文章标签更新领域事件
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Article", name = "ArticleTagsUpdatedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTagsUpdatedDomainEvent {
    Article entity;

    List<Long> removeIds;

    List<Long> addIds;
}
