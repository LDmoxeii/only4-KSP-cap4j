package com.only4.domain.aggregates.article.factory;

import com.only4.domain.aggregates.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Article聚合工厂
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Article", name = "ArticleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleFactory implements AggregateFactory<ArticleFactory.Payload, Article> {

    @Override
    public Article create(Payload payload) {

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Article工厂负载
     */
    @Aggregate(aggregate = "Article", name = "ArticlePayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Article> {
        Long authorId;
        String title;
        String description;
        String content;
        Long price;
    }
}
