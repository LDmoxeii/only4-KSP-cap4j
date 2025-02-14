package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.ArticleCategory;
import com.only4.domain.aggregates.article.ArticleTag;
import com.only4.domain.aggregates.article.enums.ArticleState;
import com.only4.domain.aggregates.article.factory.ArticleFactory;
import com.only4.domain.aggregates.category.Category;
import com.only4.domain.aggregates.tag.Tag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;

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
            val article = Mediator.factories().create(ArticleFactory.Payload
                    .builder()
                    .title(cmd.title)
                    .description(cmd.description)
                    .state(cmd.status)
                    .stickyFlag(cmd.stickyFlag)
                    .commentFlag(cmd.commentFlag)
                    .cover(cmd.cover)
                    .appendix(cmd.appendix)
                    .authors(cmd.authors)
                    .categories(cmd.categories)
                    .price(cmd.price)
                    .tags(cmd.tags)
                    .build());
            article.create();
            Mediator.uow().persist(article);
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

        ArticleState status;
        Boolean stickyFlag;
        Boolean commentFlag;
        String cover;
        Integer appendix;

        @NotEmpty
        List<ArticleAuthor> authors;

        List<ArticleCategory> categories;
        Long price;
        List<ArticleTag> tags;

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
