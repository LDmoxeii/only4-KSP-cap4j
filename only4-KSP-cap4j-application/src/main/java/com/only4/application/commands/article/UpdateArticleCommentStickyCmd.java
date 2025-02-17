package com.only4.application.commands.article;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.article.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/15
 */
public class UpdateArticleCommentStickyCmd {

    /**
     * UpdateArticleCommentStickyCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            return Optional.ofNullable(Mediator.repositories()
                            .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                            .orElseThrow(() -> new KnownException("文章不存在")))
                    .map(article -> {
                        article.updateCommentSticky(cmd.getCommentId(), cmd.getSticky());
                        Mediator.uow().persist(article);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);
        }
    }

    /**
     * UpdateArticleCommentStickyCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long articleId;

        Long commentId;

        @NotNull
        Boolean sticky;
    }

    /**
     * UpdateArticleCommentStickyCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
