package com.only4.domain.aggregates.favorite_article.factory;

import com.only4.domain.aggregates.favorite_article.FavoriteArticle;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * FavoriteArticle聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "favorite_article", name = "FavoriteArticleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class FavoriteArticleFactory implements AggregateFactory<FavoriteArticlePayload, FavoriteArticle> {

    @Override
    public FavoriteArticle create(FavoriteArticlePayload payload) {

        return FavoriteArticle.builder()

                .build();
    }
}
