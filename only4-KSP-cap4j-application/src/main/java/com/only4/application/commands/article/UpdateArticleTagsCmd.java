package com.only4.application.commands.article;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.article.Article;
import com.only4.domain.aggregates.article.dto.TagDto;
import com.only4.domain.aggregates.tag.Tag;
import jakarta.validation.constraints.NotNull;
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
 * @author cap4j-ddd-codegen
 * @date 2025/02/14
 */
public class UpdateArticleTagsCmd {

    /**
     * UpdateArticleTagCmd命令请求实现
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

            List<TagDto> tagDtos = cmd.getTags().stream()
                    .map(tag -> TagDto.builder()
                            .tagId(tag.getId())
                            .tagName(tag.getName())
                            .build())
                    .collect(Collectors.toList());

            article.updateTags(tagDtos);
            Mediator.uow().persist(article);
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

        @NotNull
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
