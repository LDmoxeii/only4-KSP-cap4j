package com.only4.application.commands.article;


import com.only4.application.validater.article.ArticleExists;
import com.only4.domain.aggregates.article.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 更新文章评论开关
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/16
 */
public class UpdateArticleCommentFlagCmd {

    /**
     * UpdateArticleCommentFlagCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                    .map(article -> {
                        article.updateCommentFlag(cmd.getCommentFlag());
                        Mediator.uow().persist(article);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);

        }
    }

    /**
     * UpdateArticleCommentFlagCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @ArticleExists
        Long articleId;

        Boolean commentFlag;

        Boolean getCommentFlag() {
            return Optional.ofNullable(commentFlag)
                    .orElse(true);
        }
    }

    /**
     * UpdateArticleCommentFlagCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
