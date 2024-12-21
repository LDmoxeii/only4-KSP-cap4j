package com.only4.domain.aggregates.article.factory;

import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.ArticleCategory;
import com.only4.domain.aggregates.article.ArticleTag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        return Article.builder()
                .id(payload.authorId)
                .title(payload.title)
                .description(payload.description)
                .content(payload.content)
                .price(payload.price)
                .cover(payload.cover)
                .appendix(payload.appendix)
                .state(payload.state)
                .stickyFlag(payload.stickyFlag)
                .commentFlag(payload.commentFlag)
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
        Long authorId;
        String title;
        String description;
        String content;
        Long price;
        String cover;
        Integer appendix;
        com.only4.domain.aggregates.article.enums.ArticleState state;
        Boolean stickyFlag;
        Boolean commentFlag;
    }
}
