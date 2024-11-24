package com.only4.domain.aggregates.favorite_article.factory;

import com.only4.domain.aggregates.favorite_article.FavoriteArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;

/**
 * FavoriteArticle工厂负载
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "favorite_article", name = "FavoriteArticlePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteArticlePayload implements AggregatePayload<FavoriteArticle> {
    String name;

}
