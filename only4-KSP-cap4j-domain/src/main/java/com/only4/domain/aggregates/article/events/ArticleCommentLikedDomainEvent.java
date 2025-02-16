package com.only4.domain.aggregates.article.events;

import com.only4.domain.aggregates.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * Article.ArticleCommentLikedDomainEvent领域事件
 * todo: 领域事件说明
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/15
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "Article", name = "ArticleCommentLikedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentLikedDomainEvent {
    Article entity;
    Long commentId;
}
