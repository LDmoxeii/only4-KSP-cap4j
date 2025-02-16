package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class LikeArticleCmd {

    /**
     * LikeArticleCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            cmd.getArticle().ifPresent(article -> {
                article.like(cmd.getMemberId(), LocalDateTime.now());
                Mediator.uow().persist(article);
            });

            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * LikeArticleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long memberId;
        Long articleId;

        {
            validateExists();
            validateNotLike();
        }

        void validateNotLike() {
            getArticle().flatMap(article -> article.getArticleLikes().stream()
                    .filter(articleLike -> articleLike.getMemberId().equals(memberId))
                    .findFirst()).ifPresent(articleLike -> {
                throw new IllegalArgumentException("您已经点赞过该文章");
            });
        }

        Optional<Article> getArticle() {
            return Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, articleId));
        }

        void validateExists() {
            if (!Mediator.repositories().exists(JpaPredicate.byId(Article.class, articleId))) {
                throw new IllegalArgumentException("文章不存在");
            }
        }
    }

    /**
     * LikeArticleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
