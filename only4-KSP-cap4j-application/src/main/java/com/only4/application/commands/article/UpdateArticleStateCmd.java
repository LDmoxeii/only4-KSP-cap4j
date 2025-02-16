package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.enums.ArticleVisibility;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class UpdateArticleStateCmd {

    /**
     * UpdateArticleStateCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                    .ifPresent(article -> {
                        article.updateVisibility(
                                Optional.ofNullable(cmd.getVisibility()).orElse(article.getVisibility()),
                                Optional.ofNullable(cmd.getStickyFlag()).orElse(article.getStickyFlag()),
                                Optional.ofNullable(cmd.getCommentFlag()).orElse(article.getCommentFlag())
                        );
                        Mediator.uow().persist(article);
                    });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateArticleStateCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long articleId;
        ArticleVisibility visibility;
        Boolean stickyFlag;
        Boolean commentFlag;
        {
            validateExists();
        }

        private void validateExists() {
            if (!Mediator.repositories().exists(JpaPredicate.byId(Article.class, articleId))) {
                throw new IllegalArgumentException("文章不存在");
            }
        }
    }

    /**
     * UpdateArticleStateCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
