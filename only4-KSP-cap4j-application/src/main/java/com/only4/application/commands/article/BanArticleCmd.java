package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.meta.ArticleSchema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class BanArticleCmd {

    /**
     * BanArticleCmd命令请求实现
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
                        article.ban(cmd.getBanDuration(), cmd.getBannedAt());
                        Mediator.uow().persist(article);
                    });
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * BanArticleCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long articleId;

        @Positive(message = "封禁时长必须大于0")
        Integer banDuration;

        LocalDateTime bannedAt;

        {
            validateExists();
            validateNotBanned();
        }

        LocalDateTime getBannedAt() {
            if (bannedAt == null) {
                bannedAt = LocalDateTime.now();
            }
            return bannedAt;
        }

        private void validateNotBanned() {
            if (!Mediator.repositories().exists(JpaPredicate.bySpecification(Article.class,
                    ArticleSchema.specify(article ->
                            article.all(
                                    article.bannedAt().isNotNull(),
                                    article.banDuration().greaterThan(0),
                                    article.bannedAt().greaterThan(LocalDateTime.now().minusMinutes(banDuration))
                            )

                    ))
            )) {
                throw new IllegalArgumentException("文章已处于封禁状态");
            }
        }

        private void validateExists() {
            if (!Mediator.repositories().exists(JpaPredicate.byId(Article.class, articleId))) {
                throw new IllegalArgumentException("文章不存在");
            }
        }
    }

    /**
     * BanArticleCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
