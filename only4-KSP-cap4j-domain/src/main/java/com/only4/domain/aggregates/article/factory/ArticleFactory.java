package com.only4.domain.aggregates.article.factory;

import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.ArticleStatistics;
import com.only4.domain.aggregates.article.dto.ArticleAuthorDto;
import com.only4.domain.aggregates.article.enums.ArticleVisibility;
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
import java.util.stream.Collectors;

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
        List<ArticleAuthor> articleAuthors = payload.getAuthors().stream()
                .map(articleAuthorDto -> ArticleAuthor.builder()
                        .authorName(articleAuthorDto.getName())
                        .authorId(articleAuthorDto.getId())
                        .build())
                .collect(Collectors.toList());

        return Article.builder()
                //创建文章
                .title(payload.getTitle())
                .description(payload.getDescription())
                .content(payload.getContent())
                .cover("")
                .appendix("")
                .price(0L)
                .visibility(ArticleVisibility.PRIVATE)
                .stickyFlag(false)
                .commentFlag(true)
                .articleAuthors(articleAuthors)
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

        String cover;

        String appendix;

        List<ArticleAuthorDto> authors;

    }
}
