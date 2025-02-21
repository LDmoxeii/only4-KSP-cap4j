package com.only4.application.commands.article;


import com.only4._share.exception.KnownException;
import com.only4.domain.aggregates.article.Article;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
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
            Article article = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Article.class, cmd.getArticleId()))
                    .orElseThrow(() -> new KnownException("文章不存在"));

            article.ban(cmd.getBanDuration());
            Mediator.uow().persist(article);
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
