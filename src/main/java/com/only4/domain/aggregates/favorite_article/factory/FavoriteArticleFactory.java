package com.only4.domain.aggregates.favorite_article.factory;

import com.only4.domain.aggregates.favorite_article.FavoriteArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * FavoriteArticle聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "FavoriteArticle", name = "FavoriteArticleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class FavoriteArticleFactory implements AggregateFactory<FavoriteArticleFactory.Payload, FavoriteArticle> {

    @Override
    public FavoriteArticle create(Payload payload) {

        return FavoriteArticle.builder()
                .favoritesId(payload.getFavoritesId())
                .articleId(payload.getArticleId())
                .build();
    }

    /**
     * FavoriteArticle工厂负载
     */
    @Aggregate(aggregate = "FavoriteArticle", name = "FavoriteArticlePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<FavoriteArticle> {
        Long favoritesId;
        Long articleId;

    }
}
