package com.only4.domain.aggregates.article_like.events;

import com.only4.domain.aggregates.article_like.ArticleLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * ArticleLike.ArticleUnlikedDomainEvent领域事件
 * 已取消点赞文章
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "ArticleLike", name = "ArticleUnlikedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUnlikedDomainEvent {
    ArticleLike entity;
}
