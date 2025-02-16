package com.only4.application.commands.article;


import com.only4.application.validater.article.ArticleExists;
import com.only4.application.validater.article.ArticleNotBanned;
import com.only4.domain.aggregates.article.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Optional;

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
            return Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                    .map(article -> {
                        article.ban(cmd.getBanDuration(), cmd.getBannedAt());
                        Mediator.uow().persist(article);
                        
                        Mediator.uow().save();
                        
                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);
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

        @ArticleExists
        Long articleId;

        @Positive(message = "封禁时长必须大于0")
        @ArticleNotBanned
        Integer banDuration;

        LocalDateTime bannedAt;

        LocalDateTime getBannedAt() {
            return Optional.ofNullable(bannedAt)
                    .orElse(LocalDateTime.now());
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
