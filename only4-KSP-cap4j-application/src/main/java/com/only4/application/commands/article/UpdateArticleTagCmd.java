package com.only4.application.commands.article;


import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleTag;
import com.only4.domain.aggregates.tag.Tag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class UpdateArticleTagCmd {

    /**
     * UpdateArticleTagCmd命令请求实现
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
                        article.updateTags(cmd.tags);
                        Mediator.uow().persist(article);
                    });
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateArticleTagCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {
        Long articleId;
        List<Tag> tags;
    }

    /**
     * UpdateArticleTagCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
