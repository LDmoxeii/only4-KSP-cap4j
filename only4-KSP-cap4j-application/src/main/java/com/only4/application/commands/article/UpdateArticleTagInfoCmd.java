package com.only4.application.commands.article;


import com.only4.application.validater.article.ArticleTagExists;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.ArticleTag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

/**
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class UpdateArticleTagInfoCmd {

    /**
     * UpdateArticleTagInfoCmd命令请求实现
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
                        article.updateTagInfo(cmd.getTagId(), cmd.getTagName());
                        Mediator.uow().persist(article);

                        Mediator.uow().save();

                        return Response.builder()
                                .success(true)
                                .build();
                    }).orElseThrow(RuntimeException::new);
        }
    }

    /**
     * UpdateArticleTagInfoCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ArticleTagExists
    public static class Request implements RequestParam<Response> {

        Long articleId;

        Long tagId;

        @NotEmpty
        String tagName;
    }

    /**
     * UpdateArticleTagInfoCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
