package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.ArticleCategory;
import com.only4.domain.aggregates.article.ArticleTag;
import com.only4.domain.aggregates.article.enums.ArticleVisibility;
import com.only4.domain.aggregates.article.factory.ArticleFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
public class CreateArticleCmd {

    /**
     * CreateArticleCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Optional.ofNullable(Mediator.factories().create(
                    ArticleFactory.Payload.builder()
                            .title(cmd.getTitle())
                            .description(cmd.getDescription())
                            .content(cmd.getContent())
                            .visibility(cmd.getVisibility())
                            .stickyFlag(cmd.getStickyFlag())
                            .commentFlag(cmd.getCommentFlag())
                            .cover(cmd.getCover())
                            .appendix(cmd.getAppendix())
                            .authors(cmd.getAuthors())
                            .categories(cmd.getCategories())
                            .price(cmd.getPrice())
                            .tags(cmd.getTags())
                            .build()
            )).ifPresent(article -> {
                article.create();
                Mediator.uow().persist(article);
            });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateArticleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        @NotEmpty
        String title;

        @NotEmpty
        String description;

        @NotEmpty
        String content;

        ArticleVisibility visibility;
        Boolean stickyFlag;
        Boolean commentFlag;
        String cover;
        String appendix;

        @NotEmpty
        List<ArticleAuthor> authors;

        List<ArticleCategory> categories;
        Long price;
        List<ArticleTag> tags;

        ArticleVisibility getVisibility() {
            return visibility == null ? ArticleVisibility.PRIVATE : visibility;
        }

        Boolean getStickyFlag() {
            return stickyFlag != null && stickyFlag;
        }

        Boolean getCommentFlag() {
            return commentFlag != null && commentFlag;
        }

        Long getPrice() {
            return price == null ? 0L : price;
        }

        List<ArticleCategory> getCategories() {
            return categories == null ? Collections.emptyList() : categories;
        }

        List<ArticleTag> getTags() {
            return tags == null ? Collections.emptyList() : tags;
        }
    }

    /**
     * CreateArticleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
