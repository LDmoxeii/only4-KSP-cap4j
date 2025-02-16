package com.only4.domain.aggregates.article.factory;

import com.only4.domain.aggregates.article.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Article聚合工厂
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/04
 */
@Aggregate(aggregate = "Article", name = "ArticleFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class ArticleFactory implements AggregateFactory<ArticleFactory.Payload, Article> {

    @Override
    public Article create(Payload payload) {
        return Article.builder()
                //创建文章
                .title(payload.title)
                .description(payload.description)
                .content(payload.content)
                .price(payload.price)
                .cover(payload.cover)
                .appendix(payload.appendix)
                .visibility(payload.visibility)
                .stickyFlag(payload.stickyFlag)
                .commentFlag(payload.commentFlag)
                .articleAuthors(payload.authors)
                .articleCategories(payload.categories)
                .articleTags(payload.tags)
                .articleStatistics(Collections.singletonList(new ArticleStatistics()))
                .build();
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
        String title;
        String description;
        String content;
        Long price;
        String cover;
        String appendix;
        com.only4.domain.aggregates.article.enums.ArticleVisibility visibility;
        Boolean stickyFlag;
        Boolean commentFlag;
        List<ArticleAuthor> authors;
        List<ArticleCategory> categories;
        List<ArticleTag> tags;

    }
}
