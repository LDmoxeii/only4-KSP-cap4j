package com.only4.application.commands.article;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleAuthor;
import com.only4.domain.aggregates.article.factory.ArticleFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

/**
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
            Article article = Optional.ofNullable(Mediator.factories().create(
                    ArticleFactory.Payload.builder()
                            .title(cmd.getTitle())
                            .description(cmd.getDescription())
                            .content(cmd.getContent())
                            .authors(cmd.getAuthors())
                            .build()
            )).orElseThrow(() -> new KnownException("文章创建失败"));

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

        @NotBlank(message = "文章标题不能为空")
        String title;

        @NotBlank(message = "文章评论不能为空")
        String description;

        @NotBlank(message = "文章内容不能为空")
        String content;

        @NotBlank(message = "文章作者不能为空")
        List<ArticleAuthor> authors;
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

        Long articleId;
    }
}
