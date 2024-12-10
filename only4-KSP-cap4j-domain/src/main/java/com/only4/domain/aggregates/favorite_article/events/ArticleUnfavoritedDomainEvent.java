package com.only4.domain.aggregates.favorite_article.events;

import com.only4.domain.aggregates.favorite_article.FavoriteArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.netcorepal.cap4j.ddd.domain.event.annotation.DomainEvent;

/**
 * FavoriteArticle.ArticleUnfavoritedDomainEvent领域事件
 * todo: 领域事件说明
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@DomainEvent(persist = false)
@Aggregate(aggregate = "FavoriteArticle", name = "ArticleUnfavoritedDomainEvent", type = Aggregate.TYPE_DOMAIN_EVENT, description = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUnfavoritedDomainEvent {
    FavoriteArticle entity;
}
