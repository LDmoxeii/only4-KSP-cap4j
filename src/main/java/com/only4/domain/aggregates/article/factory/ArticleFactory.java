package com.only4.domain.aggregates.article.factory;

import com.only4.domain.aggregates.article.Article;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Article聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/24
 */
@Aggregate(aggregate = "article", name = "ArticleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleFactory implements AggregateFactory<ArticlePayload, Article> {

    @Override
    public Article create(ArticlePayload payload) {

        return Article.builder()

                .build();
    }
}
